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
@ApiModel(value = "LevelQuality",description = "重量等级记录")
public class LevelQualityVO {

    /**
     * 重量等级记录id
     */
    @TableId(value = "lq_id", type = IdType.AUTO)
    @ApiModelProperty(value="重量等级记录id",name="lqId",required = true)
    private Long lqId;

    /**
     * 质量报告id
     */
    @TableField("qr_id")
    @ApiModelProperty(value="质量报告id",name="qrId",required = true)
    private Long qrId;

    /**
     * 类型  1:日报, 2:月报, 3:年报
     */
    @TableField("q_type")
    @ApiModelProperty(value="类型",name="qType",required = true)
    private Integer qType;

    /**
     * AA重量
     */
    @TableField("weight_aa")
    @ApiModelProperty(value="AA重量",name="weightAA",required = true)
    private Long weightAA;

    /**
     * AA比例
     */
    @TableField("ratio_aa")
    @ApiModelProperty(value="AA比例",name="ratioAA",required = true)
    private Double ratioAA;

    /**
     * A重量
     */
    @TableField("weight_a")
    @ApiModelProperty(value="A重量",name="weightA",required = true)
    private Long weightA;

    /**
     * A比例
     */
    @TableField("ratio_a")
    @ApiModelProperty(value="A比例",name="ratioA",required = true)
    private Double ratioA;

    /**
     * A1重量
     */
    @TableField("weight_a1")
    @ApiModelProperty(value="A重量",name="weightA1",required = true)
    private Long weightA1;

    /**
     * A1比例
     */
    @TableField("ratio_a1")
    @ApiModelProperty(value="A1比例",name="ratioA1",required = true)
    private Double ratioA1;

    /**
     * B重量
     */
    @TableField("weight_b")
    @ApiModelProperty(value="B重量",name="weightB",required = true)
    private Long weightB;

    /**
     * B比例
     */
    @TableField("ratio_b")
    @ApiModelProperty(value="B比例",name="ratioB",required = true)
    private Double ratioB;
}
