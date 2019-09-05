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
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "RealTimeAlarm",description = "实时告警")
public class RealTimeAlarmVO {
    /**
     * 当日锭位质量告警
     */
    @ApiModelProperty(value="当日锭位质量告警",name="spinAlarmS",required = true)
    private List<SpinAlarmVO> spinAlarmS;

    /**
     * 当日驻留告警
     */
    @ApiModelProperty(value="当日驻留告警",name="residentAlarmS",required = true)
    private List<ResidentAlarmVO> residentAlarmS;
}
