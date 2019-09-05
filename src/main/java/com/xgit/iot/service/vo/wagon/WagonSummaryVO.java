package com.xgit.iot.service.vo.wagon;

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
@ApiModel(value = "WagonSummary",description = "丝车概要信息")
public class WagonSummaryVO {

    /**
     * 工艺状态
     */
    @TableId(value = "craft_state", type = IdType.ID_WORKER)
    @ApiModelProperty(value="craftState",name="craftState",required = true)
    private Integer craftState;

    /**
     * 处在该工艺状态下的丝车总数
     */
    @TableField("total")
    @ApiModelProperty(value="total",name="total",required = true)
    private Integer total;
}
