package com.xgit.iot.service.vo.fileUpload;

import lombok.Data;

/**
 * @author huzhen
 * @email 617694858@qq.com
 * @date 2018-11-27
 * 文件上传，调用外部接口的请求
 */
@Data
public class FileUploadReqVO {
    private String originalFilename;
    private byte[] bytes;
}
