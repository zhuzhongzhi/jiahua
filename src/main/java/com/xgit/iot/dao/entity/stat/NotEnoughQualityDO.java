package com.xgit.iot.dao.entity.stat;

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
@ApiModel(value = "NotEnoughQuality",description = "重量不足记录")
public class NotEnoughQualityDO {

    private static final long serialVersionUID = 1L;

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
