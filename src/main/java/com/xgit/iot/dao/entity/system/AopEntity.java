package com.xgit.iot.dao.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "AopEntity",description = "操作日志")
public class AopEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    @ApiModelProperty(value="日志id",name="logId",required = true)
    private Long logId;

    /**
     * 客户端IP
     */
    @TableId(value = "client_ip")
    @ApiModelProperty(value="客户端IP",name="clientIp",required = true)
    private String clientIp;

    /**
     * 客户端请求路径
     */
    @TableId(value = "uri")
    @ApiModelProperty(value="客户端请求路径",name="uri",required = true)
    private String uri;

    /**
     * 请求用户名
     */
    @TableId(value = "user_name")
    @ApiModelProperty(value="请求用户名",name="userName",required = true)
    private String userName;

    /**
     * 请求用户Id
     */
    @TableId(value = "user_id")
    @ApiModelProperty(value="请求用户Id",name="userId",required = true)
    private String userId;

    /**
     * 请求时间
     */
    @TableId(value = "req_time")
    @ApiModelProperty(value="请求时间",name="reqTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reqTime;

    /**
     * 响应时间
     */
    @TableId(value = "rsp_time")
    @ApiModelProperty(value="响应时间",name="rspTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rspTime;

    /**
     * 响应结果
     */
    @TableId(value = "rsp_result")
    @ApiModelProperty(value="响应结果",name="rspResult",required = true)
    private String rspResult;
}
