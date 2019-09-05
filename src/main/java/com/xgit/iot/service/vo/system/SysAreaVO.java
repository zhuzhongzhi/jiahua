package com.xgit.iot.service.vo.system;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SysArea",description = "地区表")
public class SysAreaVO {
    /**
     * code
     */
    @TableId(value = "code", type = IdType.ID_WORKER)
    @ApiModelProperty(value="code",name="code",required = true)
    private String code;

    /**
     * 父code
     */
    @TableId(value = "pCode", type = IdType.ID_WORKER)
    @ApiModelProperty(value="父code",name="pCode",required = true)
    private String pCode;

    /**
     * 城市名称
     */
    @TableId(value = "name", type = IdType.ID_WORKER)
    @ApiModelProperty(value="城市名称",name="name",required = true)
    private String name;

    /**
     * 地区码
     */
    @TableId(value = "areaCode", type = IdType.ID_WORKER)
    @ApiModelProperty(value="地区码",name="areaCode",required = true)
    private String areaCode;
}
