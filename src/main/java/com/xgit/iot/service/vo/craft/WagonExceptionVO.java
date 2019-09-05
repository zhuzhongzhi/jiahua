package com.xgit.iot.service.vo.craft;

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
@ApiModel(value = "WagonPos",description = "丝车位置信息")
public class WagonExceptionVO {

    /**
     * 异常id
     */
    @TableId(value = "ex_id", type = IdType.AUTO)
    @ApiModelProperty(value="操作id",name="ex_id",required = true)
    private Long exId;

    /**
     * 操作id
     */
    @TableField("op_id")
    @ApiModelProperty(value="操作id",name="op_id",required = true)
    private Long opId;

    /**
     * 纺锭位
     */
    @TableField("ex_spin_pos")
    @ApiModelProperty(value="纺锭位",name="exSpinPos",required = true)
    private String exSpinPos;

    /**
     * 线别
     */
    @TableField("lousiness")
    @ApiModelProperty(value="毛丝",name="lousiness",required = false)
    private String lousiness;

    /**
     * 规格
     */
    @TableField("lousiness_level")
    @ApiModelProperty(value="毛丝等级",name="lousinessLevel",required = false)
    private String lousinessLevel;

    /**
     * 碰伤
     */
    @TableField("bruise")
    @ApiModelProperty(value="碰伤",name="bruise",required = false)
    private String bruise;

    /**
     * 碰伤等级
     */
    @TableField("bruise_level")
    @ApiModelProperty(value="碰伤等级",name="bruiseLevel",required = false)
    private String bruiseLevel;

    /**
     * 绕外
     */
    @TableField("outside")
    @ApiModelProperty(value="绕外",name="outside",required = false)
    private String outside;

    /**
     * 绕外等级
     */
    @TableField("outside_level")
    @ApiModelProperty(value="绕外等级",name="outsideLevel",required = false)
    private String outsideLevel;

    /**
     * 成型不良
     */
    @TableField("bad_shape")
    @ApiModelProperty(value="成型不良",name="badShape",required = false)
    private String badShape;

    /**
     * 成型不良等级
     */
    @TableField("bad_shape_level")
    @ApiModelProperty(value="成型不良等级",name="badShapeLevel",required = false)
    private String badShapeLevel;

    /**
     * 夹丝
     */
    @TableField("crimp")
    @ApiModelProperty(value="夹丝",name="crimp",required = false)
    private String crimp;

    /**
     * 夹丝等级
     */
    @TableField("crimp_level")
    @ApiModelProperty(value="夹丝等级",name="crimpLevel",required = false)
    private String crimpLevel;

    /**
     * 污丝
     */
    @TableField("soiled")
    @ApiModelProperty(value="污丝",name="soiled",required = false)
    private String soiled;

    /**
     * 污丝等级
     */
    @TableField("soiled_level")
    @ApiModelProperty(value="污丝等级",name="soiledLevel",required = false)
    private String soiledLevel;

    /**
     * 黄化
     */
    @TableField("yellow")
    @ApiModelProperty(value="黄化",name="yellow",required = false)
    private String yellow;

    /**
     * 黄化等级
     */
    @TableField("yellow_level")
    @ApiModelProperty(value="黄化等级",name="yellowLevel",required = false)
    private String yellowLevel;

    /**
     * 飘丝
     */
    @TableField("float_silk")
    @ApiModelProperty(value="飘丝",name="floatSilk",required = false)
    private String floatSilk;

    /**
     * 飘丝等级
     */
    @TableField("float_silk_level")
    @ApiModelProperty(value="飘丝等级",name="floatSilkLevel",required = false)
    private String floatSilkLevel;

    /**
     * 绕丝
     */
    @TableField("wind")
    @ApiModelProperty(value="绕丝",name="wind",required = false)
    private String wind;

    /**
     * 绕丝等级
     */
    @TableField("wind_level")
    @ApiModelProperty(value="绕丝等级",name="windLevel",required = false)
    private String windLevel;

    /**
     * 染色
     */
    @TableField("dye")
    @ApiModelProperty(value="染色",name="dye",required = false)
    private String dye;

    /**
     * 染色等级
     */
    @TableField("dye_level")
    @ApiModelProperty(value="染色等级",name="dyeLevel",required = false)
    private String dyeLevel;

    /**
     * 物性
     */
    @TableField("property")
    @ApiModelProperty(value="物性",name="property",required = false)
    private String property;

    /**
     * 物性等级
     */
    @TableField("property_level")
    @ApiModelProperty(value="物性等级",name="propertyLevel",required = false)
    private String propertyLevel;

    /**
     * OPU
     */
    @TableField("opu")
    @ApiModelProperty(value="OPU",name="opu",required = false)
    private String opu;

    /**
     * OPU等级
     */
    @TableField("opu_level")
    @ApiModelProperty(value="OPU等级",name="opuLevel",required = false)
    private String opuLevel;

    /**
     * 其他
     */
    @TableField("other")
    @ApiModelProperty(value="其他",name="other",required = false)
    private String other;

    /**
     * 其他等级
     */
    @TableField("other_level")
    @ApiModelProperty(value="其他等级",name="otherLevel",required = false)
    private String otherLevel;
}
