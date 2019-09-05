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
@ApiModel(value = "YearlyQualityReport",description = "年度质量报告")
public class YearlyQualityReportVO {

    /**
     * 质量报告id
     */
    @TableId(value = "qr_id", type = IdType.AUTO)
    @ApiModelProperty(value="质量报告id",name="qrId",required = true)
    private Long qrId;

    /**
     * 年份
     */
    @TableField("qr_year")
    @ApiModelProperty(value="年份",name="qrYear",required = true)
    private Integer qrYear;

    /**
     * 月份
     */
    @TableField("qr_month")
    @ApiModelProperty(value="月份",name="qrMonth",required = true)
    private Integer qrMonth;

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
