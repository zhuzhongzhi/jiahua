package com.xgit.iot.service.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.log.LogHelper;
import com.xgit.iot.dao.entity.system.SysObjectStorageDO;
import com.xgit.iot.dao.mapper.system.SysObjectStorageMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.FunctionResult;
import com.xgit.iot.infra.enums.FileStorageEngine;
import com.xgit.iot.infra.enums.FileStorageTypeEnum;
import com.xgit.iot.infra.util.FileUtil;
import com.xgit.iot.infra.util.StreamUtil;
import com.xgit.iot.manager.restTemplate.RestTemplateHelper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.fileUpload.FileUploadReqVO;
import com.xgit.iot.service.vo.fileUpload.FileUploadResVO;
import com.xgit.iot.service.vo.system.SysObjectStorageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Service
@Slf4j
public class SysObjectStorageService extends BaseService<SysObjectStorageVO, SysObjectStorageDO> {
    @Autowired
    private SysObjectStorageMapper sysObjectStorageMapper;



    @Value("${file.storage.path}")
    private String fileStoragePath;
    @Value("${file.storage.engine:0}")
    private String fileStorageEngine;
    @Value("${file.storage.external.address}")
    private String fileStorageExternalAddress;
    @Value("${file.storage.inner.address}")
    private String fileStorageInnerAddress;
    @Value("${file.storage.external.action.upload}")
    private String fileStorageExternalUpload;
    @Value("${file.storage.external.action.read}")
    private String fileStorageExternalRead;
    @Value("${imgMaxFileSize}")
    private double imgMaxFileSize;

    @Autowired
    private RestTemplateHelper restTemplateHelper;

    public SysObjectStorageService() {
        super(SysObjectStorageVO.class, SysObjectStorageDO.class);
    }

    @PostConstruct
    public void init() {
        super.addMapper(sysObjectStorageMapper);
    }

    @Override
    public SysObjectStorageVO item(String id) {
        return super.item(id);
    }

    public FunctionResult<String> insert(FileUploadResVO fileUploadVO, FileStorageEngine engine) {
        SysObjectStorageVO sysObjectStorageVO = new SysObjectStorageVO();
        FunctionResult<String> functionResult = super.getGenId();
        if (functionResult.getCode() != ErrorCode.Success) {
            return new FunctionResult<>(functionResult.getCode());
        }
        String id = functionResult.getT();
        sysObjectStorageVO.setId(id);
        sysObjectStorageVO.setFileName(fileUploadVO.getFileName());
        sysObjectStorageVO.setFilePath(fileUploadVO.getFilePath());
        sysObjectStorageVO.setStorageEngine(engine.ordinal());
        sysObjectStorageVO.setStorageType(fileUploadVO.getFileStorageTypeEnum().ordinal());
        String storageServiceAddress = StringUtils.EMPTY;
        switch (engine) {
            case LOCAL:
                storageServiceAddress = fileStorageInnerAddress;
                break;
            case SLAVE:
            case THRID_SERVICE:
                storageServiceAddress = fileStorageExternalAddress;
                break;
            default:
                break;
        }
        sysObjectStorageVO.setServiceAddress(storageServiceAddress);
        ErrorCode ret = super.insert(sysObjectStorageVO);
        if (ret != ErrorCode.Success) {
            return new FunctionResult<>(ret);
        }
        return new FunctionResult<>(id);
    }

    /**
     * 该参数表示kb的值
     * @param
     * @return
     */
    public double getMB(double b){
        double kb;
        double mb;
        kb = b / 1024.0;
        mb = kb / 1024.0;
        //返回kb转换之后的M值
        return mb;
    }
    public FunctionResult<String> upload(MultipartFile multipartFile)  {
        if (multipartFile == null) {
            return new FunctionResult<>(ErrorCode.CommFileUploadCantNull);
        }
        try{
            log.info("size:"+multipartFile.getSize());
            log.info("bytes:"+multipartFile.getBytes().length);
            log.info("calcuteValue:"+getMB(multipartFile.getSize()));
            log.info("calcuteValue:"+getMB(multipartFile.getBytes().length));
            log.info("imgMaxFileSize:"+imgMaxFileSize);
        }catch (Exception e){

        }
        if (getMB(multipartFile.getSize()) > imgMaxFileSize){
            return new FunctionResult<>(ErrorCode.CommFileUploadTooBig);
        }

        FileUploadResVO fileUploadResVO = null;
        Integer fileStorageEngineValue = Integer.parseInt(fileStorageEngine);
        FileStorageEngine engine = FileStorageEngine.values()[fileStorageEngineValue];
        try{
            switch (engine) {
                case LOCAL:
                    FunctionResult<FileUploadResVO> functionResult = FileUtil.uploadFile(multipartFile, fileStoragePath);
                    if (functionResult.getCode() != ErrorCode.Success) {
                        return new FunctionResult<>(functionResult.getCode());
                    }
                    fileUploadResVO = functionResult.getT();

                    // 上传文件保存原始文件名
                    // fileUploadResVO.setFileName(new String(multipartFile.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8"));
                    break;
                case SLAVE:
                    FileUploadReqVO fileUploadReqVO = new FileUploadReqVO();
                    fileUploadReqVO.setOriginalFilename(multipartFile.getOriginalFilename());
                    try {
                        fileUploadReqVO.setBytes(multipartFile.getBytes());
                    } catch (IOException e) {
                        return new FunctionResult<>(ErrorCode.CommFileGetBytesFailed);
                    }

                    String url = fileStorageExternalAddress + fileStorageExternalUpload;
                    FunctionResult<ActionResult> restResult = restTemplateHelper.request(url,
                            HttpMethod.POST, fileUploadReqVO, ActionResult.class, new HashMap<>());
                    if (restResult.getCode() != ErrorCode.Success) {
                        return new FunctionResult<>(restResult.getCode());
                    }
                    ActionResult actionResult = restResult.getT();
                    try {
                        fileUploadResVO = JSONObject.toJavaObject((JSON) actionResult.getValue(), FileUploadResVO.class);
                    } catch (Exception e) {
                        LogHelper.fatal(e.getMessage(), e);
                        return new FunctionResult<>(ErrorCode.CommObjectNotTargetClass);
                    }
                    break;
                case THRID_SERVICE:
                    return new FunctionResult<>(ErrorCode.CommFileUploadUnSupportByThrid);
                default:
                    break;
            }
        }catch (Exception e){
            return new FunctionResult<>(ErrorCode.FileWriteFalid);
        }
        FunctionResult<String> functionResult = this.insert(fileUploadResVO, engine);
        return functionResult;
    }

    public void read(String fileId, HttpServletResponse response) {
        SysObjectStorageVO objectStorageVO = super.item(fileId);
        if (objectStorageVO == null) {
            return;
        }
        FileStorageTypeEnum storageTypeEnum = FileStorageTypeEnum.values()[objectStorageVO.getStorageType()];
        switch (storageTypeEnum) {
            case IMAGE:
                response.setContentType("image/jpeg");
                break;
            default:
                return;
        }

        Integer engineValue = objectStorageVO.getStorageEngine();
        FileStorageEngine engine = FileStorageEngine.values()[engineValue];
        switch (engine) {
            case LOCAL:
                StreamUtil.output(objectStorageVO.getFilePath(), response);
                break;
            case SLAVE:
                //获取文件对象，转成字节数组带回来
                String url = fileStorageExternalAddress + fileStorageExternalRead +
                        "?fullFilePath=" + objectStorageVO.getFilePath();
                FunctionResult<ActionResult> restResult = restTemplateHelper.request(url,
                        HttpMethod.GET, null, ActionResult.class, new HashMap<>());
                if (restResult.getCode() != ErrorCode.Success) {
                    return;
                }
                ActionResult actionResult = restResult.getT();
                if (!(actionResult.getValue() instanceof String)) {
                    return;
                }
                try {
                    byte[] fileBytes = ((String) actionResult.getValue()).getBytes("ISO-8859-1");
                    LogHelper.debug("返回的文件字节数组长度：" + fileBytes.length);
                    StreamUtil.byte2Response(fileBytes, response);
                } catch (Exception e) {
                    return;
                }
                break;
            case THRID_SERVICE:
                return;
            default:
                break;
        }
    }

    /**
     * 服务间调用上传接口
     *
     * @param fileUploadReqVO
     * @return
     */
    public FunctionResult<FileUploadResVO> servicesCallUpload(FileUploadReqVO fileUploadReqVO) {
        FunctionResult<FileUploadResVO> functionResult = FileUtil.uploadFile(fileUploadReqVO, fileStoragePath);
        return functionResult;
    }

    public void download(String fileId,String repairManualId,HttpServletResponse response){
        SysObjectStorageVO objectStorageVO = super.item(fileId);
        if (objectStorageVO == null) {
            return;
        }
        //获取文件对象，转成字节数组带回来
        String url = fileStorageExternalAddress + fileStorageExternalRead +
                "?fullFilePath=" + objectStorageVO.getFilePath();
        FunctionResult<ActionResult> restResult = restTemplateHelper.request(url,
                HttpMethod.GET, null, ActionResult.class, new HashMap<>());
        if (restResult.getCode() != ErrorCode.Success) {
            return;
        }
        ActionResult actionResult = restResult.getT();
        if (!(actionResult.getValue() instanceof String)) {
            return;
        }
        try {

            response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
            response.addHeader("Content-Disposition", "attachment;filename="+new String("维修记录".getBytes("UTF-8"),"ISO-8859-1"));
            byte[] fileBytes = ((String) actionResult.getValue()).getBytes("ISO-8859-1");
            LogHelper.debug("返回的文件字节数组长度：" + fileBytes.length);
            System.out.println("返回的文件字节数组长度：" + fileBytes.length);
            StreamUtil.byte2Response(fileBytes, response);

        }catch (Exception e){

        }
    }
}
