package com.xgit.iot.web.wagon;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import com.xgit.iot.service.vo.wagon.WagonSummaryVO;
import com.xgit.iot.service.wagon.SilkWagonService;
import com.xgit.iot.service.wagon.WagonPosService;
import com.xgit.iot.service.wagon.WagonSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 丝车监控
 */
@RequestMapping("/wagon")
@Api(tags = "丝车监控")
@RestController
public class SilkWagonController extends BasicController{

    @Autowired
    private SilkWagonService silkWagonService;

    @Autowired
    private WagonSummaryService wagonSummaryService;

    @Autowired
    private WagonPosService wagonPosService;
    /**
     * 丝车概要信息
     * @return
     */
    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    @ApiOperation("丝车概要信息")
    public ActionResult summary(){
        List<WagonSummaryVO> volist = wagonSummaryService.summary();
        return actionResult(volist);
    }

    /**
     * 新增丝车信息
     * @param condition
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增丝车信息")
    public ActionResult addWagon(@RequestBody SilkWagonVO entity){
        Long result = silkWagonService.addWagon(entity);
        return actionResult(result);
    }

    /**
     * 丝车信息分页
     * @param condition
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("丝车信息分页")
    public ActionResult page(@RequestBody SearchCommonVO<SilkWagonVO> condition){
        PageCommonVO result = silkWagonService.list(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 获取所有丝车信息分页显示
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/allWagonPage", method = RequestMethod.GET)
    @ApiOperation("获取所有丝车信息分页显示")
    public ActionResult allWagonPage(@RequestParam int pageNum, @RequestParam int pageSize){
        PageCommonVO result = silkWagonService.listAllWagon(pageNum, pageSize);
        return actionResult(result.getPageInfo());
    }

    /**
     * 获取条件查询的丝车信息分页显示(模糊查询)
     * @param condition
     * @return
     */
    @RequestMapping(value = "/allWagonPageCondtion", method = RequestMethod.POST)
    @ApiOperation("获取条件查询的丝车信息分页显示(模糊查询)")
    public ActionResult allWagonPageCondtion(@RequestBody SearchCommonVO<SilkWagonVO> condition){
        PageCommonVO result = silkWagonService.listAllWagonCondition(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 丝车信息列表
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("丝车信息列表")
    public ActionResult list(@RequestBody SearchCommonVO<SilkWagonVO> condition){
        List<SilkWagonVO> result = silkWagonService.listAll(condition);
        return actionResult(result);
    }

    /**
     * 获取丝车所有位置
     * @param code
     * @return
     */
    @RequestMapping(value = "/posCurrent", method = RequestMethod.GET)
    @ApiOperation("获取丝车当前位置")
    public ActionResult posCurrent(@RequestParam String code){
        WagonPosVO result = wagonPosService.wagonPos(code);
        return actionResult(result);
    }

    /**
     * 获取丝车所有位置
     * @param code
     * @return
     */
    @RequestMapping(value = "/posList", method = RequestMethod.GET)
    @ApiOperation("获取丝车所有位置")
    public ActionResult posList(@RequestParam String code){
        List<WagonPosVO> result = wagonPosService.listWagonPos(code);
        return actionResult(result);
    }
}
