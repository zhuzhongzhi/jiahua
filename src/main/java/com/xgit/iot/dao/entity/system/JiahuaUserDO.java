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
@ApiModel(value = "JiahuaUser",description = "嘉华用户")
public class JiahuaUserDO {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ju_id", type = IdType.AUTO)
    @ApiModelProperty(value="id",name="juId",required = true)
    private Long juId;

    /**
     * 用户id
     */
    @TableId(value = "user_id")
    @ApiModelProperty(value="用户id",name="userId",required = true)
    private String userId;

    /**
     * 纺位
     */
    @TableField("user_name")
    @ApiModelProperty(value="纺位",name="userName",required = true)
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    @ApiModelProperty(value="密码",name="password",required = false)
    private String password;

    /**
     * 岗位
     */
    @TableField("post")
    @ApiModelProperty(value="岗位",name="post",required = false)
    private String post;

    /**
     * 单位
     */
    @TableField("institution")
    @ApiModelProperty(value="单位",name="institution",required = false)
    private String institution;

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
