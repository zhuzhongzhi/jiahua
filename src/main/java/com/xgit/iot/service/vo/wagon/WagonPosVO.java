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
@ApiModel(value = "WagonPos",description = "丝车位置信息")
public class WagonPosVO {

    /**
     * 位置记录id
     */
    @TableId(value = "pos_id", type = IdType.AUTO)
    @ApiModelProperty(value="位置记录id",name="pos_id",required = true)
    private Long posId;

    /**
     * 丝车编码
     */
    @TableField("code")
    @ApiModelProperty(value="丝车编码",name="code",required = true)
    private String code;

    /**
     * 位置信息X
     */
    @TableField("pos_info_x")
    @ApiModelProperty(value="位置信息X",name="pos_info_x",required = true)
    private String posInfoX;

    /**
     * 位置信息Y
     */
    @TableField("pos_info_y")
    @ApiModelProperty(value="位置信息Y",name="pos_info_y",required = true)
    private String posInfoY;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value="更新时间",name="updateTime",required = false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
