package com.xgit.iot.service.vo.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 对象存储服务表
 *
 * @author huzhen
 * @email 617694858@qq.com
 * @date 2018-11-23 09:52:32
 */
@Data
public class SysObjectStorageVO {
    /**
     * 对象存储的标识id
     */
    @ApiModelProperty(value = "对象存储的标识id")
    private String id;
    /**
     * 存储引擎，1：本地、2：其他服务器、3：第三方服务
     */
    @ApiModelProperty(value = "存储引擎，0：本地、1：其他服务器、2：第三方服务")
    private Integer storageEngine;
    /**
     * 非本地的存储引擎的服务地址
     */
    @ApiModelProperty(value = "非本地的存储引擎的服务地址")
    private String serviceAddress;
    /**
     * 存储类型,1:图片，2：视频，3：音频，4：文件，5：其他类型
     */
    @ApiModelProperty(value = "存储类型,0:图片，1：视频，2：音频，3：其他类型")
    private Integer storageType;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

}
