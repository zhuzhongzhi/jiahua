package com.xgit.iot.service.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
@ApiModel(value = "CommonVO",description = "班组、检点等")
public class CommonVO {


    /**
     * id
     */
    @ApiModelProperty(value="id",name="id",required = true)
    private String id;

    /**
     * 值
     */
    @ApiModelProperty(value="label",name="label",required = true)
    private String label;

    /**
     * 值
     */
    @ApiModelProperty(value="val",name="val",required = true)
    private String val;



}
