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
        WagonSummaryVO voInfo = wagonSummaryService.summary();
        return actionResult(voInfo);
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
