package com.xgit.iot.service.vo.warn;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "LineDeal",description = "线别质量告警处理信息")
public class LineDealVO {
    /**
     * 线别质量告警
     */
    @ApiModelProperty(value="线别质量告警",name="lineAlarm",required = true)
    private LineAlarmVO lineAlarm;

    /**
     * 处理人
     */
    @ApiModelProperty(value="处理人",name="operator",required = true)
    private String operator;

    /**
     * 处理时间
     */
    @ApiModelProperty(value="生产日期",name="handleTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date handleTime;

    /**
     * 处理备注
     */
    @ApiModelProperty(value="处理备注",name="remark",required = true)
    private String remark;
}
