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
@ApiModel(value = "NotEnoughQuality",description = "重量不足记录")
public class NotEnoughQualityVO {

    /**
     * 重量不足记录id
     */
    @TableId(value = "neq_id", type = IdType.AUTO)
    @ApiModelProperty(value="重量不足记录id",name="neqId",required = true)
    private Long neqId;

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
     * 重量
     */
    @TableField("weight")
    @ApiModelProperty(value="重量",name="weight",required = true)
    private Long weight;

    /**
     * 比例
     */
    @TableField("ratio")
    @ApiModelProperty(value="比例",name="ratio",required = true)
    private Double ratio;
}
