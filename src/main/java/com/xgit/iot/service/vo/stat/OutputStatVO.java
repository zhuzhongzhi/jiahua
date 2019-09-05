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
@ApiModel(value = "OutputStat",description = "产量统计")
public class OutputStatVO {

    /**
     * 记录id
     */
    @TableId(value = "os_id", type = IdType.AUTO)
    @ApiModelProperty(value="记录id",name="osId",required = true)
    private Long osId;

    /**
     * 生产日期
     */
    @TableField("produce_time")
    @ApiModelProperty(value="月份",name="produceTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /**
     * 班别
     */
    @TableField("class_type")
    @ApiModelProperty(value="班别",name="classType",required = true)
    private String classType;

    /**
     * 工号
     */
    @TableField("operator")
    @ApiModelProperty(value="工号",name="operator",required = true)
    private String operator;

    /**
     * 批号
     */
    @TableField("batch_num")
    @ApiModelProperty(value="批号",name="batchNum",required = true)
    private String batchNum;

    /**
     * 规格
     */
    @TableField("standard")
    @ApiModelProperty(value="规格",name="standard",required = true)
    private String standard;

    /**
     * 车辆数
     */
    @TableField("wagon_num")
    @ApiModelProperty(value="车辆数",name="wagonNum",required = true)
    private Integer wagonNum;

    /**
     * 锭数
     */
    @TableField("ingot_num")
    @ApiModelProperty(value="锭数",name="ingotNum",required = true)
    private Integer ingotNum;

    /**
     * 工艺状态
     */
    @TableField("craft_state")
    @ApiModelProperty(value="锭数",name="craftState",required = true)
    private Integer craftState;

    /**
     * 产量
     */
    @TableField("output")
    @ApiModelProperty(value="产量",name="output",required = true)
    private Integer output;
}
