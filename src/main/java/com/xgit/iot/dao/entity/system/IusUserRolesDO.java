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

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IusUserProfile",description = "用户角色关系表")
public class IusUserRolesDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("user_id")
    @ApiModelProperty(value="用户id",name="userId",required = true)
    private String userId;

    /**
     * 角色id
     */
    @TableField("role_id")
    @ApiModelProperty(value="角色id",name="roleId",required = true)
    private String roleId;

    /**
     *
     */
    @TableField("role_flag")
    @ApiModelProperty(name="roleFlag",required = true)
    private Integer roleFlag;
}
