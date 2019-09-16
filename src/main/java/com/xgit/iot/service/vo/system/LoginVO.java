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
@ApiModel(value = "Login",description = "登录信息")
public class LoginVO {

    /**
     * 用户名
     */
    @ApiModelProperty(value="纺位",name="userName",required = true)
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码",name="password",required = false)
    private String password;

    /**
     * 是否记住密码
     */
    @ApiModelProperty(value="是否记住密码",name="remberMe",required = false)
    private Integer remberMe;
}
