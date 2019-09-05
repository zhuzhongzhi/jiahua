package com.xgit.iot.service.vo.board;

import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "LineQualityThreeDays",description = "近三日线别不良排名")
public class LineQualityThreeDaysVO {

    /**
     * 当日最大线别不良信息
     */
    @ApiModelProperty(value="当日最大线别不良信息",name="lineQualityBoardVOToday",required = true)
    private LineQualityBoardVO lineQualityBoardVOToday;

    /**
     * 昨日最大线别不良信息
     */
    @ApiModelProperty(value="昨日最大线别不良信息",name="lineQualityBoardVOYesterday",required = true)
    private LineQualityBoardVO lineQualityBoardVOYesterday;

    /**
     * 前日最大线别不良信息
     */
    @ApiModelProperty(value="前日最大线别不良信息",name="lineQualityBoardVOBeforeYesterday",required = true)
    private LineQualityBoardVO lineQualityBoardVOBeforeYesterday;
}
