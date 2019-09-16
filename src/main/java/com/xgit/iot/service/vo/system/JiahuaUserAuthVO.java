package com.xgit.iot.service.vo.system;

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
@ApiModel(value = "JiahuaUserAuth",description = "嘉华用户权限")
public class JiahuaUserAuthVO {

    /**
     * id
     */
    @TableId(value = "jua_id", type = IdType.AUTO)
    @ApiModelProperty(value="id",name="juaId",required = true)
    private Long juaId;

    /**
     * 用户id
     */
    @TableId(value = "user_id")
    @ApiModelProperty(value="用户id",name="userId",required = true)
    private String userId;

    /**
     * 权限id
     */
    @TableField("auth_id")
    @ApiModelProperty(value="权限id",name="authId",required = true)
    private String authId;

    /**
     * 岗位
     */
    @TableField("post")
    @ApiModelProperty(value="岗位",name="post",required = false)
    private String post;

    /**
     * 状态
     */
    @TableField("status")
    @ApiModelProperty(value="状态",name="status",required = false)
    private Integer status;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
