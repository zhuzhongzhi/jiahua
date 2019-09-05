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
@ApiModel(value = "IusPassword",description = "密码信息")
public class IusPasswordVO {

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    @ApiModelProperty(value="用户id",name="userId",required = true)
    private String userId;

    /**
     * 密码
     */
    @TableField("password")
    @ApiModelProperty(value="密码",name="password",required = true)
    private String password;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 类型
     */
    @TableField("type")
    @ApiModelProperty(value="类型",name="type",required = true)
    private Double type;
}
