package com.xgit.iot.dao.entity.craft;

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
public class WagonOperateDO {

    private static final long serialVersionUID = 1L;

    /**
     * 操作id
     */
    @TableId(value = "op_id", type = IdType.AUTO)
    @ApiModelProperty(value="操作id",name="opId",required = true)
    private Long opId;

    /**
     * 丝车编码
     */
    @TableField("code")
    @ApiModelProperty(value="丝车编码",name="code",required = true)
    private String code;

    /**
     * 丝车定位标签ID
     */
    @TableField("tag_id")
    @ApiModelProperty(value="丝车定位标签ID",name="tagId",required = true)
    private String tagId;

    /**
     * 操作员
     */
    @TableField("operator")
    @ApiModelProperty(value="操作员",name="operator",required = true)
    private String operator;

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
     * 批号
     */
    @TableField("batch_num")
    @ApiModelProperty(value="批号",name="batchNum",required = false)
    private String batchNum;

    /**
     * 班别
     */
    @TableField("class_type")
    @ApiModelProperty(value="班别",name="classType",required = false)
    private String classType;

    /**
     * 纺位
     */
    @TableField("spin_pos")
    @ApiModelProperty(value="纺位",name="spinPos",required = false)
    private String spinPos;

    /**
     * 生产日期
     */
    @TableField("produce_time")
    @ApiModelProperty(value="生产日期",name="produceTime",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /**
     * 工艺状态
     */
    @TableField("craft_state")
    @ApiModelProperty(value="工艺状态",name="craftState",required = true)
    private Integer craftState;

    /**
     * 丝车当前的工艺状态
     */
    @TableField("cur_craft_state")
    @ApiModelProperty(value="丝车当前的工艺状态",name="curCraftState",required = true)
    private Integer curCraftState;

    /**
     * 工艺开始时间
     */
    @TableField("craft_time")
    @ApiModelProperty(value="工艺开始时间",name="craftTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date craftTime;

    /**
     * 工号
     */
    @TableField("job_code")
    @ApiModelProperty(value="工号",name="jobCode",required = false)
    private String jobCode;

    /**
     * 落丝时间
     */
    @TableField("doffing_time")
    @ApiModelProperty(value="落丝时间",name="doffingTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doffingTime;

    /**
     * 净重
     */
    @TableField("weight")
    @ApiModelProperty(value="净重",name="weight",required = false)
    private Integer weight;


    /**
     * 第一次落丝时间
     */
    @TableField("doffing_time1")
    @ApiModelProperty(value="第一次落丝时间",name="doffingTime1",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doffingTime1;

    /**
     * 第一次落丝纺位
     */
    @TableField("doffing_spin_pos1")
    @ApiModelProperty(value="第一次落丝纺位",name="doffingSpinPos1",required = false)
    private String doffingSpinPos1;

    /**
     * 第一次落丝净重
     */
    @TableField("weight1")
    @ApiModelProperty(value="第一次落丝净重",name="weight1",required = false)
    private Integer weight1;

    /**
     * 第一次落丝时间
     */
    @TableField("doffing_time2")
    @ApiModelProperty(value="第二次落丝时间",name="doffingTime2",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doffingTime2;

    /**
     * 第一次落丝纺位
     */
    @TableField("doffing_spin_pos2")
    @ApiModelProperty(value="第二次落丝纺位",name="doffingSpinPos2",required = false)
    private String doffingSpinPos2;

    /**
     * 第一次落丝净重
     */
    @TableField("weight2")
    @ApiModelProperty(value="第二次落丝净重",name="weight2",required = false)
    private Integer weight2;

    /**
     * 第一次落丝时间
     */
    @TableField("doffing_time3")
    @ApiModelProperty(value="第三次落丝时间",name="doffingTime3",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doffingTime3;

    /**
     * 第一次落丝纺位
     */
    @TableField("doffing_spin_pos3")
    @ApiModelProperty(value="第三次落丝纺位",name="doffingSpinPos3",required = false)
    private String doffingSpinPos3;

    /**
     * 第一次落丝净重
     */
    @TableField("weight3")
    @ApiModelProperty(value="第三次落丝净重",name="weight3",required = false)
    private Integer weight3;

    /**
     * 要因记录
     */
    @TableField("cause")
    @ApiModelProperty(value="要因记录",name="cause",required = false)
    private String cause;

    /**
     * 锭数
     */
    @TableField("ingot_num")
    @ApiModelProperty(value="锭数",name="ingotNum",required = false)
    private String ingotNum;

    /**
     * 锭位合股次数
     */
    @TableField("joint_num")
    @ApiModelProperty(value="锭位合股次数",name="jointNum",required = false)
    private String jointNum;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
