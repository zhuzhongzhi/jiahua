package com.xgit.iot.dao.entity.wagon;

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
public class WagonSummaryDO {

    private static final long serialVersionUID = 1L;

    /**
     * 工艺状态
     */
    @TableId(value = "craft_state", type = IdType.ID_WORKER)
    @ApiModelProperty(value="工艺状态",name="craftState",required = true)
    private Integer craftState;

    /**
     * 处在该工艺状态下的丝车总数
     */
    @TableField("total")
    @ApiModelProperty(value="处在该工艺状态下的丝车总数",name="total",required = true)
    private Integer total;
}
