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
@ApiModel(value = "LineSpin",description = "线别纺位")
public class LineSpinDO {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ls_id", type = IdType.AUTO)
    @ApiModelProperty(value="id",name="lsId",required = true)
    private Long lsId;

    /**
     * 线别
     */
    @TableId(value = "line_type")
    @ApiModelProperty(value="线别",name="lineType",required = true)
    private String lineType;

    /**
     * 纺位
     */
    @TableField("spin_pos")
    @ApiModelProperty(value="纺位",name="spinPos",required = true)
    private String spinPos;

    /**
     * 锭数
     */
    @TableField("ingot_num")
    @ApiModelProperty(value="锭数",name="ingotNum",required = false)
    private Integer ingotNum;
}
