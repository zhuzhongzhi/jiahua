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
@ApiModel(value = "AlarmHandleLog",description = "告警处理日志信息")
public class AlarmHandleLogDO {

    private static final long serialVersionUID = 1L;

    /**
     * 告警id
     */
    @TableId(value = "handle_id", type = IdType.AUTO)
    @ApiModelProperty(value="告警ID",name="handleId",required = true)
    private Long handleId;

    /**
     * 告警ID
     */
    @TableId(value = "alarm_id")
    @ApiModelProperty(value="告警ID",name="alarmId",required = true)
    private Long alarmId;

    /**
     * 告警类型
     */
    @TableField("alarm_type")
    @ApiModelProperty(value="告警类型",name="alarmType",required = false)
    private String alarmType;

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
     * 建卡时间
     */
    @TableField("card_time")
    @ApiModelProperty(value="建卡时间",name="cardTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cardTime;

    /**
     * 处理时间
     */
    @TableField("handle_time")
    @ApiModelProperty(value="处理时间",name="handleTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date handleTime;


    /**
     * 处理人
     */
    @TableField("operator")
    @ApiModelProperty(value="处理人",name="operator",required = false)
    private String operator;


    /**
     * 处理备注
     */
    @TableField("remark")
    @ApiModelProperty(value="处理备注",name="remark",required = false)
    private String remark;
}
