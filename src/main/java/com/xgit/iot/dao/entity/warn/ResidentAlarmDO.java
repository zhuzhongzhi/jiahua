package com.xgit.iot.dao.entity.warn;

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
@ApiModel(value = "ResidentAlarm",description = "驻留告警")
public class ResidentAlarmDO {

    private static final long serialVersionUID = 1L;

    /**
     * 告警ID
     */
    @TableId(value = "alarm_id", type = IdType.AUTO)
    @ApiModelProperty(value="告警ID",name="alarmId",required = true)
    private Long alarmId;

    /**
     * 丝车编号
     */
    @TableField("code")
    @ApiModelProperty(value="丝车编号",name="code",required = false)
    private String code;

    /**
     * 工艺状态
     */
    @TableField("craft_state")
    @ApiModelProperty(value="工艺状态",name="craftState",required = false)
    private Integer craftState;

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
     * 落丝时间
     */
    @TableField("doffing_time")
    @ApiModelProperty(value="落丝时间",name="doffing_time",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doffingTime;

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
     * 异常比例
     */
    @TableField("exception_ratio")
    @ApiModelProperty(value="异常比例",name="exceptionRatio",required = false)
    private String exceptionRatio;

    /**
     * 是否处理过了
     */
    @TableField("is_handled")
    @ApiModelProperty(value="是否处理过了",name="isHandled",required = false)
    private Integer isHandled;
}
