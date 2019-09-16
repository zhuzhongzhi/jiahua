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
@ApiModel(value = "JiahuaAuth",description = "嘉华权限")
public class JiahuaAuthDO {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ja_id", type = IdType.AUTO)
    @ApiModelProperty(value="id",name="jaId",required = true)
    private Long jaId;

    /**
     * 权限id
     */
    @TableId(value = "auth_id")
    @ApiModelProperty(value="权限id",name="authId",required = true)
    private String authId;

    /**
     * 权限名
     */
    @TableField("auth_name")
    @ApiModelProperty(value="权限名",name="authName",required = true)
    private String authName;

    /**
     * 描述
     */
    @TableField("desc")
    @ApiModelProperty(value="描述",name="desc",required = false)
    private String desc;
}
