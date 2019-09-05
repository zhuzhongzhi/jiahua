package com.xgit.iot.service.vo.stat;

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
@ApiModel(value = "MonthlyQualityReport",description = "月度质量报告")
public class MonthlyQualityReportVO {

    /**
     * 质量报告id
     */
    @TableId(value = "qr_id", type = IdType.AUTO)
    @ApiModelProperty(value="质量报告id",name="qrId",required = true)
    private Long qrId;

    /**
     * 月份
     */
    @TableField("month_time")
    @ApiModelProperty(value="月份",name="monthTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date monthTime;

    /**
     * 批号
     */
    @TableField("batch_num")
    @ApiModelProperty(value="批号",name="batchNum",required = true)
    private String batchNum;

    /**
     * 线别
     */
    @TableField("line_type")
    @ApiModelProperty(value="线别",name="lineType",required = true)
    private String lineType;

    /**
     * 规格
     */
    @TableField("standard")
    @ApiModelProperty(value="规格",name="standard",required = true)
    private String standard;

    /**
     * 检验重量
     */
    @TableField("weight")
    @ApiModelProperty(value="检验重量",name="weight",required = true)
    private Integer weight;
}
