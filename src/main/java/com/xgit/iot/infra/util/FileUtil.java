package com.xgit.iot.infra.util;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.FunctionResult;
import com.xgit.iot.infra.enums.FileStorageTypeEnum;
import com.xgit.iot.service.vo.fileUpload.FileUploadReqVO;
import com.xgit.iot.service.vo.fileUpload.FileUploadResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by zhuliqing on 2017-09-07.
 */
public class FileUtil {
    @Autowired
    private GenClient genClient;

    /**
     * 文件上传
     */
    private static FunctionResult<FileUploadResVO> uploadFile(String originalFilename, byte[] fileBytes, String fileFolderPath) {
        // 截取文件后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 文件重命名
        String fileName = UUID.randomUUID().toString() + suffix;
        Integer year = DateUtils.getYear();
        Integer month = DateUtils.getMonth();
        Integer day = DateUtils.getDay();

        StringBuffer buffer = new StringBuffer();
        buffer.append(fileFolderPath)
                .append("/").append(year.toString())
                .append("/").append(month.toString())
                .append("/").append(day.toString());
        String path = buffer.toString();
        String fullFilePath = path + "/" + fileName;

        //todo 获取文件类型
        FileUploadResVO fileUploadVO = new FileUploadResVO(fileName, fullFilePath, FileStorageTypeEnum.IMAGE);
        try {
            File uploadFile = new File(fullFilePath);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            FileCopyUtils.copy(fileBytes, uploadFile);
        } catch (IOException e) {
            return new FunctionResult<>(ErrorCode.CommFileCreateFailed);
        }
        return new FunctionResult<>(fileUploadVO);
    }

    public static FunctionResult<FileUploadResVO> uploadFile(MultipartFile multipartFile, String fileFolderPath) {
        if (multipartFile.isEmpty()) {
            return new FunctionResult<>(ErrorCode.CommFileUploadCantNull);
        }
        try{
            return uploadFile(multipartFile.getOriginalFilename(), multipartFile.getBytes(), fileFolderPath);
        }catch (IOException e){
            return new FunctionResult<>(ErrorCode.CommFileGetBytesFailed);
        }
    }

    public static FunctionResult<FileUploadResVO> uploadFile(FileUploadReqVO fileUploadReqVO, String fileFolderPath) {
        if (fileUploadReqVO == null) {
            return new FunctionResult<>(ErrorCode.CommFileUploadCantNull);
        }
        return uploadFile(fileUploadReqVO.getOriginalFilename(), fileUploadReqVO.getBytes(), fileFolderPath);
    }

    public static void replaceFile(MultipartFile file, String filePath) throws Exception {
        try {
            File uploadFile = new File(filePath);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            FileCopyUtils.copy(file.getBytes(), uploadFile);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    public static void downLoadFile(HttpServletResponse response, String filePath, String fileName) throws Exception {
        String downloadFilename = fileName;
        downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");

        File file = new File(filePath + fileName);
        if (file.exists()) {
            createOutPutStream(response, file, downloadFilename);
        }
    }

    public static void downloadFileAndRename(HttpServletResponse response, String filePath, String fileName) throws Exception {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.lastIndexOf("."), filePath.length());
        if (file.exists()) {
            String downloadFilename = URLEncoder.encode(fileName + suffix, "UTF-8");
            createOutPutStream(response, file, downloadFilename);
        }
    }

    private static void createOutPutStream(HttpServletResponse response, File file, String fileName) throws Exception {
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
        response.setContentType("application/octet-stream");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] b = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(b);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(b);
        bufferedInputStream.close();
        outputStream.flush();
        outputStream.close();
    }

    public static boolean fileIsExist(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }
}
