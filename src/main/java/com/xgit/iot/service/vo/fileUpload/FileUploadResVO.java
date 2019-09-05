package com.xgit.iot.service.vo.fileUpload;

import com.xgit.iot.infra.enums.FileStorageTypeEnum;

import java.io.Serializable;

/**
 * @author huzhen
 * @email 617694858@qq.com
 * @date 2018-11-26
 */

public class FileUploadResVO implements Serializable {
    private String fileName;
    private String filePath;
    private FileStorageTypeEnum fileStorageTypeEnum;

    public FileUploadResVO() {
    }

    public FileUploadResVO(String fileName, String filePath, FileStorageTypeEnum fileStorageTypeEnum) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileStorageTypeEnum = fileStorageTypeEnum;
    }

    public FileStorageTypeEnum getFileStorageTypeEnum() {
        return fileStorageTypeEnum;
    }

    public void setFileStorageTypeEnum(FileStorageTypeEnum fileStorageTypeEnum) {
        this.fileStorageTypeEnum = fileStorageTypeEnum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
