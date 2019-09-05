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
 * 工作空间
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IusWorkspace",description = "工作空间")
public class IusWorkspaceDO {


    private static final long serialVersionUID = 1L;

    /**
     * 工作空间ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value="工作空间ID",name="id",required = true)
    private String id;

    /**
     * 工作空间名称
     */
    @ApiModelProperty(value="工作空间名称",name="name",required = true)
    private String name;

    /**
     * 端口号
     */
    @ApiModelProperty(value="端口号",name="site",required = true)
    private Double site;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remark",required = true)
    private String remark;

    /**
     * 状态
     */
    @ApiModelProperty(value="状态",name="status",required = true)
    private Double status;

    @TableField("temp_id")
    @ApiModelProperty(name="tempId",required = true)
    private String tempId;

    @TableField("space_type")
    @ApiModelProperty(name="spaceType",required = true)
    private Integer spaceType;
}
