package com.xgit.iot.service.vo.board;

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
@ApiModel(value = "ProduceBoard",description = "产量信息汇总表")
public class ProduceBoardVO {

    /**
     * 记录id
     */
    @TableId(value = "pb_id", type = IdType.AUTO)
    @ApiModelProperty(value="记录id",name="pbId",required = true)
    private Long pbId;

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
     * 总产量(KG)
     */
    @TableField("total_weight")
    @ApiModelProperty(value="总产量(KG)",name="totalWeight",required = true)
    private Integer totalWeight;

    /**
     * 质量为AA的重量(KG)
     */
    @TableField("aa_weight")
    @ApiModelProperty(value="质量为AA的重量(KG)",name="AAWeight",required = true)
    private Integer AAWeight;

    /**
     * 质量为A的重量(KG)
     */
    @TableField("a_weight")
    @ApiModelProperty(value="质量为A的重量(KG)",name="AWeight",required = true)
    private Integer AWeight;

    /**
     * 质量为A1的重量(KG)
     */
    @TableField("a1_weight")
    @ApiModelProperty(value="质量为A1的重量(KG)",name="A1Weight",required = true)
    private Integer A1Weight;

    /**
     * 质量为B的重量(KG)
     */
    @TableField("b_weight")
    @ApiModelProperty(value="质量为B的重量(KG)",name="BWeight",required = true)
    private Integer BWeight;

    /**
     * 落丝的重量(KG)
     */
    @TableField("doffing_weight")
    @ApiModelProperty(value="落丝的重量(KG)",name="doffingWeight",required = true)
    private Integer doffingWeight;

    /**
     * 测丹尼的重量(KG)
     */
    @TableField("test_danny_weight")
    @ApiModelProperty(value="测丹尼的重量(KG)",name="testDannyWeight",required = true)
    private Integer testDannyWeight;

    /**
     * 摇袜的重量(KG)
     */
    @TableField("rock_weight")
    @ApiModelProperty(value="摇袜的重量(KG)",name="rockWeight",required = true)
    private Integer rockWeight;

    /**
     * 判色的重量(KG)
     */
    @TableField("colour_weight")
    @ApiModelProperty(value="判色的重量(KG)",name="colourWeight",required = true)
    private Integer colourWeight;

    /**
     * 检验的重量(KG)
     */
    @TableField("check_weight")
    @ApiModelProperty(value="检验的重量(KG)",name="checkWeight",required = true)
    private Integer checkWeight;

    /**
     * 包装的重量(KG)
     */
    @TableField("package_weight")
    @ApiModelProperty(value="包装的重量(KG)",name="packageWeight",required = true)
    private Integer packageWeight;
}
