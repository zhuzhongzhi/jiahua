package com.xgit.iot.web.system;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.log.LogHelper;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.FunctionResult;
import com.xgit.iot.infra.util.StreamUtil;
import com.xgit.iot.service.system.SysObjectStorageService;
import com.xgit.iot.service.vo.fileUpload.FileUploadReqVO;
import com.xgit.iot.service.vo.fileUpload.FileUploadResVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 对象存储服务表
 *
 * @author huzhen
 * @email 617694858@qq.com
 * @date 2018-11-23 09:52:32
 */
@RestController
@RequestMapping("/SysObjectStorage")
public class SysObjectStorageController extends BasicController {
    @Autowired
    private SysObjectStorageService storageService;

    @ApiOperation(value = "文件上传接口")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ActionResult upload(MultipartFile file) {
        FunctionResult<String> functionResult = storageService.upload(file);
        if (functionResult.getCode() != ErrorCode.Success) {
            return actionResult(functionResult.getCode());
        }
        return actionResult(functionResult.getT());
    }

    @ApiOperation(value = "文件读取接口")
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(String fileId, HttpServletResponse response) {
        storageService.read(fileId, response);
    }

    @ApiOperation(value = "服务器间调用的文件上传接口")
    @RequestMapping(value = "/servicesCallUpload", method = RequestMethod.POST)
    public ActionResult<FileUploadResVO> servicesCallUpload(@RequestBody FileUploadReqVO file) {
        FunctionResult<FileUploadResVO> functionResult = storageService.servicesCallUpload(file);
        if (functionResult.getCode() != ErrorCode.Success) {
            return actionResult(functionResult.getCode());
        }
        return actionResult(functionResult.getT());
    }

    @ApiOperation(value = "服务器间调用的文件读取接口")
    @RequestMapping(value = "/servicesCallRead", method = RequestMethod.GET)
    public ActionResult<String> servicesCallRed(String fullFilePath) {
        byte[] bytes = StreamUtil.file2byte(fullFilePath);
        LogHelper.debug("获取的文件字节数组长度：" + bytes.length);
        String bytesStr = null;
        try {
            bytesStr = new String(bytes, "ISO-8859-1");
        } catch (Exception e) {
        }
        return actionResult(bytesStr);
    }

    @ApiOperation(value = "文件下载接口")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(String fileId,String repairManualId, HttpServletResponse response) {
        System.out.println("文件名:"+repairManualId);
        storageService.download(fileId,repairManualId, response);
    }

    @ApiOperation(value = "被调用的测试接口")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ActionResult test2(@RequestParam String name, @RequestParam String name2) {
        return actionResult(name+name2);
    }

}
