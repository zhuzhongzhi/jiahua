package com.xgit.iot.service.vo.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xgit.iot.dao.entity.system.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 用户资料信息
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IusProfile",description = "用户资料信息")
public class IusProfileVO {

    /**
     * 用户信息ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value="用户信息ID",name="id",required = true)
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名",name="name",required = true)
    private String name;

    /**
     * 手机
     */
    @ApiModelProperty(value="手机",name="mobile",required = true)
    private String mobile;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话",name="telephone",required = true)
    private String telephone;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别",name="sex",required = true)
    private Double sex;

    /**
     * 机构ID
     */
    @TableField("dept_id")
    @ApiModelProperty(value="机构ID",name="deptId",required = true)
    private String deptId;

    /**
     * 图标
     */
    @ApiModelProperty(value="图标",name="icon",required = true)
    private String icon;

    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称",name="nickname",required = true)
    private String nickname;

    /**
     * email
     */
    @ApiModelProperty(value="email",name="email",required = true)
    private String email;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remark",required = true)
    private String remark;

    /**
     * 是否锁定
     */
    @ApiModelProperty(value="是否锁定",name="locked",required = true)
    private Double locked;

    /**
     * 创建时间
     */
    @TableField("create_date")
    @ApiModelProperty(value="创建时间",name="createDate",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 工作空间ID
     */
    @TableField("space_id")
    @ApiModelProperty(value="工作空间ID",name="spaceId",required = true)
    private String spaceId;

    /**
     * 身份证号
     */
    @TableField("id_number")
    @ApiModelProperty(value="身份证号",name="idNumber",required = true)
    private String idNumber;

    /**
     * 地区编码
     */
    @TableField("area_code")
    @ApiModelProperty(value="地区编码",name="areaCode",required = true)
    private String areaCode;



    /**
     * 角色信息表
     */
    @ApiModelProperty(value="角色信息表",name="iusRoleDO",required = true)
    private IusRoleDO iusRoleDO;

    /**
     * 机构表
     */
    @ApiModelProperty(value="机构表",name="sysCompanyDO",required = true)
    private SysCompanyDO sysCompanyDO;

    /**
     * 用户角色关系表
     */
    @ApiModelProperty(value="用户角色关系表",name="iusUserRolesDO",required = true)
    private IusUserRolesDO IusUserRolesDO;

    /**
     * 工作空间
     */
    @ApiModelProperty(value="工作空间",name="iusWorkspaceDO",required = true)
    private IusWorkspaceDO IusWorkspaceDO;

    /**
     * 账号信息表
     */
    @ApiModelProperty(value="账号信息表",name="iusAccountDO",required = true)
    private IusAccountDO iusAccountDO;



    /**
     * 员工id
     */
    @TableField("work_personnel_id")
    @ApiModelProperty(value="员工id",name="workPersonnelId",required = true)
    private String workPersonnelId;


    /**
     *  用户类型
     */
    @ApiModelProperty(value = "用户类型",name = "userType",required = true)
    private  String  userType;
}
