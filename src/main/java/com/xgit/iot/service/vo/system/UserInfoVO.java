package com.xgit.iot.service.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "UserInfo",description = "用户信息")
public class UserInfoVO {

    /**
     * 用户信息
     */
    @ApiModelProperty(value="用户信息",name="jiahuaUser",required = true)
    private JiahuaUserVO jiahuaUser;

    /**
     * 用户权限信息
     */
    @ApiModelProperty(value="用户权限信息",name="jiahuaUserAuthList",required = false)
    private List<JiahuaUserAuthVO> jiahuaUserAuthList;
}
