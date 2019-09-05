package com.xgit.iot.service.vo.common;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 车辆监控信息
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-08
 */
@Data
@ApiModel(value = "OrgsVO",description = "组织结构")
public class OrgsVO {


    /**
     * 流水号
     */
    @ApiModelProperty(value="机构id",name="id",required = true)
    private String id;

    /**
     * 值
     */
    @ApiModelProperty(value="key",name="key",required = true)
    private String key;

    /**
     * 机构名
     */
    @ApiModelProperty(value="机构名",name="name",required = true)
    private String title;

    /**
     * 父节点
     */
    @ApiModelProperty(value="父节点Id",name="parentId",required = true)
    private String parentId;

    /**
     * 机构id(机构表)
     */
    @ApiModelProperty(value="子机构",name="children",required = true)
    private List<OrgsVO> children;



}
