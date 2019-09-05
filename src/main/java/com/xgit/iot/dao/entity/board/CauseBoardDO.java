package com.xgit.iot.dao.entity.board;

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
@ApiModel(value = "CauseBoard",description = "不良因素发生数量表")
public class CauseBoardDO {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    @TableId(value = "cb_id", type = IdType.AUTO)
    @ApiModelProperty(value="记录id",name="cbId",required = true)
    private Long cbId;

    /**
     * 生产日期
     */
    @TableField("produce_time")
    @ApiModelProperty(value="生产日期",name="produceTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 毛丝问题数
     */
    @TableField("lousiness")
    @ApiModelProperty(value="毛丝问题数",name="lousiness",required = true)
    private Double lousiness;

    /**
     * 碰伤问题数
     */
    @TableField("bruise")
    @ApiModelProperty(value="碰伤问题数",name="bruise",required = true)
    private Double bruise;

    /**
     * 绕外问题数
     */
    @TableField("outside")
    @ApiModelProperty(value="绕外问题数",name="outside",required = true)
    private Double outside;

    /**
     * 成型不良问题数
     */
    @TableField("bad_shape")
    @ApiModelProperty(value="成型不良问题数",name="badShape",required = true)
    private Double badShape;

    /**
     * 夹丝问题数
     */
    @TableField("crimp")
    @ApiModelProperty(value="夹丝问题数",name="crimp",required = true)
    private Double crimp;

    /**
     * 污丝问题数
     */
    @TableField("soiled")
    @ApiModelProperty(value="污丝问题数",name="soiled",required = true)
    private Double soiled;

    /**
     * 黄化问题数
     */
    @TableField("yellow")
    @ApiModelProperty(value="黄化问题数",name="yellow",required = true)
    private Double yellow;

    /**
     * 飘丝问题数
     */
    @TableField("float_silk")
    @ApiModelProperty(value="飘丝问题数",name="floatSilk",required = true)
    private Double floatSilk;

    /**
     * 绕丝问题数
     */
    @TableField("wind")
    @ApiModelProperty(value="绕丝问题数",name="wind",required = true)
    private Double wind;

    /**
     * 染色问题数
     */
    @TableField("dye")
    @ApiModelProperty(value="染色问题数",name="dye",required = true)
    private Double dye;

    /**
     * 物性问题数
     */
    @TableField("property")
    @ApiModelProperty(value="物性问题数",name="property",required = true)
    private Double property;

    /**
     * OPU问题数
     */
    @TableField("opu")
    @ApiModelProperty(value="OPU问题数",name="opu",required = true)
    private Double opu;

    /**
     * other问题数
     */
    @TableField("other")
    @ApiModelProperty(value="other问题数",name="other",required = true)
    private Double other;
}
