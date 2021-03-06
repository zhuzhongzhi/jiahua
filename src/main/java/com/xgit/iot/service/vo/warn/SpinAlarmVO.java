package com.xgit.iot.service.vo.warn;

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
@ApiModel(value = "SpinAlarm",description = "锭位质量告警信息")
public class SpinAlarmVO {
    /**
     * 告警ID
     */
    @TableId(value = "alarm_id", type = IdType.AUTO)
    @ApiModelProperty(value="告警ID",name="alarmId",required = true)
    private Long alarmId;

    /**
     * 批号
     */
    @TableField("batch_num")
    @ApiModelProperty(value="批号",name="batch_num",required = true)
    private String batchNum;

    /**
     * 线别
     */
    @TableField("line_type")
    @ApiModelProperty(value="线别",name="lineType",required = false)
    private String lineType;

    /**
     * 规格
     */
    @TableField("standard")
    @ApiModelProperty(value="规格",name="standard",required = false)
    private String standard;


    /**
     * 生产日期
     */
    @TableField("produce_time")
    @ApiModelProperty(value="生产日期",name="produceTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /**
     * 告警日期
     */
    @TableField("alarm_time")
    @ApiModelProperty(value="生产日期",name="alarmTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date alarmTime;

    /**
     * 锭位
     */
    @TableField("ingot_pos")
    @ApiModelProperty(value="锭位",name="ingotPos",required = false)
    private Integer ingotPos;

    /**
     * 纺位
     */
    @TableField("spin_pos")
    @ApiModelProperty(value="纺位",name="spinPos",required = false)
    private String spinPos;

    /**
     * 告警类型
     */
    @TableField("alarm_type")
    @ApiModelProperty(value="告警类型",name="alarmType",required = false)
    private String alarmType;

    /**
     * 告警等级
     */
    @TableField("alarm_level")
    @ApiModelProperty(value="告警等级",name="alarmLevel",required = false)
    private String alarmLevel;

    /**
     * 告警次数
     */
    @TableField("alarm_times")
    @ApiModelProperty(value="告警次数",name="alarmTimes",required = false)
    private Integer alarmTimes;

    /**
     * 是否处理过了
     */
    @TableField("is_handled")
    @ApiModelProperty(value="是否处理过了",name="isHandled",required = false)
    private Integer isHandled;
}
