package com.xgit.iot.service.vo.board;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "LineQualityThreeDays",description = "近三日线别不良排名")
public class QualityInfoVO {

    /**
     * 当日要因问题数
     */
    @ApiModelProperty(value="当日要因问题数",name="causeList",required = true)
    List<CauseBoardVO> causeList;

    /**
     * 三日线别染色不良
     */
    @ApiModelProperty(value="三日线别染色不良",name="dyeList",required = true)
    private LineQualityThreeDaysVO dyeList;

    /**
     * 三日线别毛丝不良
     */
    @ApiModelProperty(value="三日线别毛丝不良",name="lousinessList",required = true)
    private LineQualityThreeDaysVO lousinessList;

    /**
     * 三日线别飘丝不良
     */
    @ApiModelProperty(value="三日线别飘丝不良",name="floatSilkList",required = true)
    private LineQualityThreeDaysVO floatSilkList;

    /**
     * 三日线别绕丝不良
     */
    @ApiModelProperty(value="三日线别绕丝不良",name="windList",required = true)
    private LineQualityThreeDaysVO windList;
}
