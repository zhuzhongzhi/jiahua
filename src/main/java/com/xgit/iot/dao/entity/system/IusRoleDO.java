package com.xgit.iot.dao.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IusRole",description = "角色信息")
public class IusRoleDO {


    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value="角色ID",name="id",required = true)
    private String id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value="角色名称",name="name",required = true)
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remark",required = true)
    private String remark;

    /**
     * 角色类型
     */
    @ApiModelProperty(value="角色类型",name="type",required = true)
    private Integer type;

    /**
     * channel
     */
    @ApiModelProperty(value="channel",name="channel",required = true)
    private Integer channel;

    /**
     * 工作空间ID
     */
    @TableField("space_id")
    @ApiModelProperty(value="工作空间ID",name="spaceId",required = true)
    private String spaceId;

    /**
     * 机构id
     */
    @TableField("dept_id")
    @ApiModelProperty(value="机构id",name="deptId",required = true)
    private String deptId;


    /**
     * 排序序号
     */
    @TableField("seq_no")
    @ApiModelProperty(value="排序序号",name="seqNo",required = true)
    private Integer seqNo;

    /**
     * 机构表
     */
    @ApiModelProperty(value="机构表",name="sysCompanyDO",required = true)
    private SysCompanyDO sysCompanyDO;



}
