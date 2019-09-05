package com.xgit.iot.service.vo.craft;

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
@ApiModel(value = "WagonPos",description = "丝车位置信息")
public class WagonOEVO {

    /**
     * 操作信息
     */
    @ApiModelProperty(value="操作信息",name="wagonOperate",required = true)
    private WagonOperateVO wagonOperate;

    /**
     * 操作异常列表
     */
    @ApiModelProperty(value="操作异常列表",name="wagonExceptions",required = true)
    private List<WagonExceptionVO> wagonExceptions;
}
