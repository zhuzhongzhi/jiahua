package com.xgit.iot.dao.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "IusAccount",description = "账号信息表")
public class IusAccountDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    @ApiModelProperty(value="用户id",name="userId",required = true)
    private String userId;

    /**
     * 登陆名
     */
    @TableField("login_name")
    @ApiModelProperty(value="登陆名",name="loginName",required = true)
    private String loginName;

    /**
     * 上次登陆时间
     */
    @TableField("last_login_time")
    @ApiModelProperty(value="上次登陆时间",name="lastLoginTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 上次登陆ip
     */
    @TableField("last_login_ip")
    @ApiModelProperty(value="上次登陆ip",name="lastLoginIp",required = true)
    private String lastLoginIp;

    /**
     * 状态
     */
    @TableField("status")
    @ApiModelProperty(value="状态",name="status",required = true)
    private Double status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @ApiModelProperty(value="创建时间",name="createTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
