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
@ApiModel(value = "SlikWagon",description = "丝车信息表")
public class SilkWagonVO {

    /**
     * 丝车编码
     */
    @TableId(value = "code", type = IdType.ID_WORKER)
    @ApiModelProperty(value="丝车编码",name="code",required = true)
    private String code;

    /**
     * 工艺状态
     */
    @TableField("craft_state")
    @ApiModelProperty(value="工艺状态",name="craftState",required = true)
    private Integer craftState;

    /**
     * 批号
     */
    @TableField("batch_num")
    @ApiModelProperty(value="批号",name="batchNum",required = false)
    private String batchNum;

    /**
     * 车间
     */
    @TableField("shop")
    @ApiModelProperty(value="车间",name="shop",required = false)
    private String shop;

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
     * 是否有效
     */
    @TableField("valid")
    @ApiModelProperty(value="是否有效",name="valid",required = true)
    private Integer valid;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
