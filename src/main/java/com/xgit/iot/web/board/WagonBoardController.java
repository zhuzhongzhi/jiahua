package com.xgit.iot.web.board;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.dao.entity.board.LineQualityBoardDO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.service.board.CauseBoardService;
import com.xgit.iot.service.board.LineQualityBoardService;
import com.xgit.iot.service.board.ProduceBoardService;
import com.xgit.iot.service.craft.WagonExceptionService;
import com.xgit.iot.service.craft.WagonOperateService;
import com.xgit.iot.service.vo.board.*;
import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOEVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工艺流程管理
 */
@RequestMapping("/board")
@Api(tags = "看板管理")
@RestController
public class WagonBoardController extends BasicController{

    @Autowired
    private LineQualityBoardService lineQualityBoardService;

    @Autowired
    private CauseBoardService causeBoardService;

    @Autowired
    private ProduceBoardService produceBoardService;

    /**
     * 今日产量查询
     * @return
     */
    @RequestMapping(value = "/output/today", method = RequestMethod.GET)
    @ApiOperation("今日产量查询")
    public ActionResult outputToday(){
        List<ProduceBoardVO> result = produceBoardService.listCurDate();
        return actionResult(result);
    }

    /**
     * 历史产量查询
     * @return
     */
    @RequestMapping(value = "/output/history", method = RequestMethod.GET)
    @ApiOperation("历史产量查询")
    public ActionResult outputHistory(){
        List<ProduceBoardVO> result = produceBoardService.listRecent();
        return actionResult(result);
    }

    /**
     * 产量信息更新
     * @return
     */
    @RequestMapping(value = "/output/update", method = RequestMethod.POST)
    @ApiOperation("产量信息更新")
    public ActionResult outputUpdate(@RequestBody ProduceBoardVO entity){
        Integer result = produceBoardService.modifyBoard(entity);
        return actionResult(result);
    }

    /**
     * 产量信息更新
     * @return
     */
    @RequestMapping(value = "/output/add", method = RequestMethod.POST)
    @ApiOperation("产量信息新增")
    public ActionResult outputAdd(@RequestBody ProduceBoardVO entity){
        Long result = produceBoardService.addBoard(entity);
        return actionResult(result);
    }

    /**
     * 今日质量查询
     * @return
     */
    @RequestMapping(value = "/quality/today", method = RequestMethod.GET)
    @ApiOperation("今日质量查询")
    public ActionResult qualityToday(){
        QualityInfoVO qualityInfo = new QualityInfoVO();
        LineQualityThreeDaysVO dyeList = lineQualityBoardService.listDye();
        qualityInfo.setDyeList(dyeList);
        LineQualityThreeDaysVO floatSilkList = lineQualityBoardService.listFloatSilk();
        qualityInfo.setFloatSilkList(floatSilkList);
        LineQualityThreeDaysVO lousinessList = lineQualityBoardService.listLousiness();
        qualityInfo.setLousinessList(lousinessList);
        LineQualityThreeDaysVO windList = lineQualityBoardService.listWind();
        qualityInfo.setWindList(windList);

        List<CauseBoardVO> causeList = causeBoardService.listCurDate();
        qualityInfo.setCauseList(causeList);
        return actionResult(qualityInfo);
    }

    /**
     * 新增要因信息更新
     * @return
     */
    @RequestMapping(value = "/cause/add", method = RequestMethod.POST)
    @ApiOperation("新增要因信息更新")
    public ActionResult causeAdd(@RequestBody CauseBoardVO entity){
        Long result = causeBoardService.addBoard(entity);
        return actionResult(result);
    }

    /**
     * 要因信息更新
     * @return
     */
    @RequestMapping(value = "/cause/modify", method = RequestMethod.POST)
    @ApiOperation("要因信息更新")
    public ActionResult causeModify(@RequestBody CauseBoardVO entity){
        Integer result = causeBoardService.modifyBoard(entity);
        return actionResult(result);
    }

    /**
     * 线别不良率信息更新
     * @return
     */
    @RequestMapping(value = "/line/add", method = RequestMethod.POST)
    @ApiOperation("线别不良率信息更新")
    public ActionResult lineAdd(@RequestBody LineQualityBoardVO entity){
        Long result = lineQualityBoardService.addBoard(entity);
        return actionResult(result);
    }

    /**
     * 线别不良率信息更新
     * @return
     */
    @RequestMapping(value = "/line/modify", method = RequestMethod.POST)
    @ApiOperation("线别不良率信息更新")
    public ActionResult lineModify(@RequestBody LineQualityBoardVO entity){
        Integer result = lineQualityBoardService.modifyBoard(entity);
        return actionResult(result);
    }
}
