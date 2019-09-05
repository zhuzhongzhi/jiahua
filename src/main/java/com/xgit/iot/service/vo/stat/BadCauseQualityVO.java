package com.xgit.iot.service.vo.stat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "BadCauseQuality",description = "不良因素记录")
public class BadCauseQualityVO {

    /**
     * 不良因素记录id
     */
    @TableId(value = "bcq_id", type = IdType.AUTO)
    @ApiModelProperty(value="不良因素记录id",name="bcqId",required = true)
    private Long bcqId;

    /**
     * 质量报告id
     */
    @TableField("qr_id")
    @ApiModelProperty(value="质量报告id",name="qrId",required = true)
    private Long qrId;

    /**
     * 毛丝重量
     */
    @TableField("weight_lousiness")
    @ApiModelProperty(value="毛丝重量",name="weightLousiness",required = true)
    private Integer weightLousiness;

    /**
     * 毛丝比例
     */
    @TableField("ratio_lousiness")
    @ApiModelProperty(value="毛丝比例",name="ratioLousiness",required = true)
    private Double ratioLousiness;

    /**
     * 碰伤重量
     */
    @TableField("weight_bruise")
    @ApiModelProperty(value="碰伤重量",name="weightBruise",required = true)
    private Integer weightBruise;

    /**
     * 碰伤比例
     */
    @TableField("ratio_bruise")
    @ApiModelProperty(value="碰伤比例",name="ratioBruise",required = true)
    private Double ratioBruise;

    /**
     * 绕外重量
     */
    @TableField("weight_outside")
    @ApiModelProperty(value="绕外重量",name="weightOutside",required = true)
    private Integer weightOutside;

    /**
     * 绕外比例
     */
    @TableField("ratio_outside")
    @ApiModelProperty(value="绕外比例",name="ratioOutside",required = true)
    private Double ratioOutside;

    /**
     * 成型不良重量
     */
    @TableField("weight_bad_shape")
    @ApiModelProperty(value="成型不良重量",name="weightBadShape",required = true)
    private Integer weightBadShape;

    /**
     * 成型不良比例
     */
    @TableField("ratio_bad_shape")
    @ApiModelProperty(value="成型不良比例",name="ratioBadShape",required = true)
    private Double ratioBadShape;

    /**
     * 夹丝重量
     */
    @TableField("weight_crimp")
    @ApiModelProperty(value="夹丝重量",name="weightCrimp",required = true)
    private Integer weightCrimp;

    /**
     * 夹丝比例
     */
    @TableField("ratio_crimp")
    @ApiModelProperty(value="夹丝比例",name="ratioCrimp",required = true)
    private Double ratioCrimp;

    /**
     * 污丝重量
     */
    @TableField("weight_soiled")
    @ApiModelProperty(value="污丝重量",name="weightSoiled",required = true)
    private Integer weightSoiled;

    /**
     * 污丝比例
     */
    @TableField("ratio_soiled")
    @ApiModelProperty(value="污丝比例",name="ratioSoiled",required = true)
    private Double ratioSoiled;

    /**
     * 黄化重量
     */
    @TableField("weight_yellow")
    @ApiModelProperty(value="黄化重量",name="weightYellow",required = true)
    private Integer weightYellow;

    /**
     * 黄化比例
     */
    @TableField("ratio_yellow")
    @ApiModelProperty(value="黄化比例",name="ratioYellow",required = true)
    private Double ratioYellow;

    /**
     * 飘丝重量
     */
    @TableField("weight_float")
    @ApiModelProperty(value="飘丝重量",name="weightFloat",required = true)
    private Integer weightFloat;

    /**
     * 飘丝比例
     */
    @TableField("ratio_float")
    @ApiModelProperty(value="飘丝比例",name="ratioFloat",required = true)
    private Double ratioFloat;

    /**
     * 绕丝重量
     */
    @TableField("weight_wind")
    @ApiModelProperty(value="绕丝重量",name="weightWind",required = true)
    private Integer weightWind;

    /**
     * 绕丝比例
     */
    @TableField("ratio_wind")
    @ApiModelProperty(value="绕丝比例",name="ratioWind",required = true)
    private Double ratioWind;

    /**
     * 染色重量
     */
    @TableField("weight_dye")
    @ApiModelProperty(value="染色重量",name="weightDye",required = true)
    private Integer weightDye;

    /**
     * 染色比例
     */
    @TableField("ratio_dye")
    @ApiModelProperty(value="染色比例",name="ratioDye",required = true)
    private Double ratioDye;

    /**
     * 物性重量
     */
    @TableField("weight_property")
    @ApiModelProperty(value="物性重量",name="weightProperty",required = true)
    private Integer weightProperty;

    /**
     * 物性比例
     */
    @TableField("ratio_property")
    @ApiModelProperty(value="物性比例",name="ratioProperty",required = true)
    private Double ratioProperty;

    /**
     * OPU重量
     */
    @TableField("weight_opu")
    @ApiModelProperty(value="OPU重量",name="weightOPU",required = true)
    private Integer weightOPU;

    /**
     * OPU比例
     */
    @TableField("ratio_opu")
    @ApiModelProperty(value="OPU比例",name="ratioOPU",required = true)
    private Double ratioOPU;

    /**
     * 其他重量
     */
    @TableField("weight_other")
    @ApiModelProperty(value="其他重量",name="weightOther",required = true)
    private Integer weightOther;

    /**
     * 其他比例
     */
    @TableField("ratio_other")
    @ApiModelProperty(value="其他比例",name="ratioOther",required = true)
    private Double ratioOther;
}
