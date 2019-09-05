package com.xgit.iot.dao.entity.board;

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
@ApiModel(value = "LineQualityBoard",description = "线别质量不良率信息")
public class LineQualityBoardDO {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    @TableId(value = "lqb_id", type = IdType.AUTO)
    @ApiModelProperty(value="记录id",name="lqbId",required = true)
    private Long lqbId;

    /**
     * 生产日期
     */
    @TableField("produce_time")
    @ApiModelProperty(value="生产日期",name="produceTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /**
     * 线别
     */
    @TableField("line_type")
    @ApiModelProperty(value="线别",name="lineType",required = true)
    private String lineType;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 毛丝产量百分比
     */
    @TableField("lousiness_ratio")
    @ApiModelProperty(value="毛丝产量百分比",name="lousinessRatio",required = true)
    private Double lousinessRatio;

    /**
     * 碰伤产量百分比
     */
    @TableField("bruise_ratio")
    @ApiModelProperty(value="碰伤产量百分比",name="bruiseRatio",required = true)
    private Double bruiseRatio;

    /**
     * 绕外产量百分比
     */
    @TableField("outside_ratio")
    @ApiModelProperty(value="绕外产量百分比",name="outsideRatio",required = true)
    private Double outsideRatio;

    /**
     * 成型不良产量百分比
     */
    @TableField("bad_shape_ratio")
    @ApiModelProperty(value="成型不良产量百分比",name="badShapeRatio",required = true)
    private Double badShapeRatio;

    /**
     * 夹丝产量百分比
     */
    @TableField("crimp_ratio")
    @ApiModelProperty(value="夹丝产量百分比",name="crimpRatio",required = true)
    private Double crimpRatio;

    /**
     * 污丝产量百分比
     */
    @TableField("soiled_ratio")
    @ApiModelProperty(value="污丝产量百分比",name="soiledRatio",required = true)
    private Double soiledRatio;

    /**
     * 黄化产量百分比
     */
    @TableField("yellow_ratio")
    @ApiModelProperty(value="黄化产量百分比",name="yellowRatio",required = true)
    private Double yellowRatio;

    /**
     * 飘丝产量百分比
     */
    @TableField("float_silk_ratio")
    @ApiModelProperty(value="飘丝产量百分比",name="floatSilkRatio",required = true)
    private Double floatSilkRatio;

    /**
     * 绕丝产量百分比
     */
    @TableField("wind_ratio")
    @ApiModelProperty(value="绕丝产量百分比",name="windRatio",required = true)
    private Double windRatio;

    /**
     * 染色产量百分比
     */
    @TableField("dye_ratio")
    @ApiModelProperty(value="染色产量百分比",name="dyeRatio",required = true)
    private Double dyeRatio;

    /**
     * 物性产量百分比
     */
    @TableField("property_ratio")
    @ApiModelProperty(value="物性产量百分比",name="propertyRatio",required = true)
    private Double propertyRatio;

    /**
     * OPU产量百分比
     */
    @TableField("opu_ratio")
    @ApiModelProperty(value="OPU产量百分比",name="opuRatio",required = true)
    private Double opuRatio;

    /**
     * other产量百分比
     */
    @TableField("other_ratio")
    @ApiModelProperty(value="other产量百分比",name="otherRatio",required = true)
    private Double otherRatio;
}
