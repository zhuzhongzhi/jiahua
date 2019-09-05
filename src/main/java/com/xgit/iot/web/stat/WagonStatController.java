package com.xgit.iot.web.stat;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.service.craft.WagonExceptionService;
import com.xgit.iot.service.craft.WagonOperateService;
import com.xgit.iot.service.stat.*;
import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOEVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import com.xgit.iot.service.vo.stat.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工艺流程管理
 */
@RequestMapping("/stat")
@Api(tags = "工艺流程管理")
@RestController
public class WagonStatController extends BasicController{

    @Autowired
    private OutputStatService outputStatService;

    @Autowired
    private DailyQualityReportService dailyQualityReportService;

    @Autowired
    private MonthlyQualityReportService monthlyQualityReportService;

    @Autowired
    private YearlyQualityReportService yearlyQualityReportService;

    @Autowired
    private LevelQualityService levelQualityService;

    @Autowired
    private NotEnoughQualityService notEnoughQualityService;

    @Autowired
    private BadCauseQualityService badCauseQualityService;

    /**
     * 产量统计查询当前时间产量信息
     * @return
     */
    @RequestMapping(value = "/output/listCur", method = RequestMethod.GET)
    @ApiOperation("产量统计查询当前时间产量信息")
    public ActionResult outputListCur(){
        List<OutputStatVO> result = outputStatService.listCurDate();
        return actionResult(result);
    }

    /**
     * 产量统计查询列表
     * @return
     */
    @RequestMapping(value = "/output/list", method = RequestMethod.GET)
    @ApiOperation("产量统计查询列表")
    public ActionResult outputList(@RequestBody SearchCommonVO<OutputStatVO> condition){
        List<OutputStatVO> result = outputStatService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 产量统计查询分页
     * @return
     */
    @RequestMapping(value = "/output/page", method = RequestMethod.GET)
    @ApiOperation("产量统计查询分页")
    public ActionResult outputPage(@RequestBody SearchCommonVO<OutputStatVO> condition){
        PageCommonVO<OutputStatVO> result = outputStatService.listPageDate(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 新增产量统计信息
     * @return
     */
    @RequestMapping(value = "/output/add", method = RequestMethod.POST)
    @ApiOperation("产量统计查询分页")
    public ActionResult outputAdd(@RequestBody OutputStatVO entity){
        Long result = outputStatService.addStat(entity);
        return actionResult(result);
    }

    /**
     * 修改产量统计信息
     * @return
     */
    @RequestMapping(value = "/output/modify", method = RequestMethod.POST)
    @ApiOperation("修改统计查询分页")
    public ActionResult outputModify(@RequestBody OutputStatVO entity){
        Integer result = outputStatService.modifyStat(entity);
        return actionResult(result);
    }

    /**
     * 今日质量报告查询
     * @return
     */
    @RequestMapping(value = "/daily/listCur", method = RequestMethod.GET)
    @ApiOperation("今日质量报告查询")
    public ActionResult dailyListCur(){
        List<DailyQualityReportVO> result = dailyQualityReportService.listCurDate();
        return actionResult(result);
    }

    /**
     * 每日质量报告查询列表
     * @return
     */
    @RequestMapping(value = "/daily/list", method = RequestMethod.GET)
    @ApiOperation("每日质量报告查询列表")
    public ActionResult dailyList(@RequestBody SearchCommonVO<DailyQualityReportVO> condition){
        List<DailyQualityReportVO> result = dailyQualityReportService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 每日质量查询分页
     * @return
     */
    @RequestMapping(value = "/daily/page", method = RequestMethod.GET)
    @ApiOperation("每日质量查询分页")
    public ActionResult dailyPage(@RequestBody SearchCommonVO<DailyQualityReportVO> condition){
        PageCommonVO<DailyQualityReportVO> result = dailyQualityReportService.listPageDate(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 新增每日质量信息
     * @return
     */
    @RequestMapping(value = "/daily/add", method = RequestMethod.POST)
    @ApiOperation("新增每日质量信息")
    public ActionResult dailyAdd(@RequestBody DailyQualityReportVO entity){
        Long result = dailyQualityReportService.addStat(entity);
        return actionResult(result);
    }

    /**
     * 修改每日质量信息
     * @return
     */
    @RequestMapping(value = "/daily/modify", method = RequestMethod.POST)
    @ApiOperation("修改每日质量信息")
    public ActionResult dailyModify(@RequestBody DailyQualityReportVO entity){
        Integer result = dailyQualityReportService.modifyStat(entity);
        return actionResult(result);
    }

    /**
     * 当前月度质量报告查询
     * @return
     */
    @RequestMapping(value = "/monthly/listCur", method = RequestMethod.GET)
    @ApiOperation("当前月度质量报告查询")
    public ActionResult monthlyListCur(){
        List<MonthlyQualityReportVO> result = monthlyQualityReportService.listCurDate();
        return actionResult(result);
    }

    /**
     * 月度质量报告查询列表
     * @return
     */
    @RequestMapping(value = "/monthly/list", method = RequestMethod.GET)
    @ApiOperation("月度质量报告查询列表")
    public ActionResult monthlyList(@RequestBody SearchCommonVO<MonthlyQualityReportVO> condition){
        List<MonthlyQualityReportVO> result = monthlyQualityReportService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 月度质量查询分页
     * @return
     */
    @RequestMapping(value = "/monthly/page", method = RequestMethod.GET)
    @ApiOperation("月度质量查询分页")
    public ActionResult monthlyPage(@RequestBody SearchCommonVO<MonthlyQualityReportVO> condition){
        PageCommonVO<MonthlyQualityReportVO> result = monthlyQualityReportService.listPageDate(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 新增月度质量信息
     * @return
     */
    @RequestMapping(value = "/monthly/add", method = RequestMethod.POST)
    @ApiOperation("新增月度质量信息")
    public ActionResult monthlyAdd(@RequestBody MonthlyQualityReportVO entity){
        Long result = monthlyQualityReportService.addStat(entity);
        return actionResult(result);
    }

    /**
     * 修改月度质量信息
     * @return
     */
    @RequestMapping(value = "/monthly/modify", method = RequestMethod.POST)
    @ApiOperation("修改月度质量信息")
    public ActionResult monthlyModify(@RequestBody MonthlyQualityReportVO entity){
        Integer result = monthlyQualityReportService.modifyStat(entity);
        return actionResult(result);
    }

    /**
     * 当前年度质量报告查询
     * @return
     */
    @RequestMapping(value = "/yearly/listCur", method = RequestMethod.GET)
    @ApiOperation("当前年度质量报告查询")
    public ActionResult yearlyListCur(){
        List<YearlyQualityReportVO> result = yearlyQualityReportService.listCurDate();
        return actionResult(result);
    }

    /**
     * 年度质量报告查询列表
     * @return
     */
    @RequestMapping(value = "/yearly/list", method = RequestMethod.GET)
    @ApiOperation("年度质量报告查询列表")
    public ActionResult yearlyList(@RequestBody SearchCommonVO<YearlyQualityReportVO> condition){
        List<YearlyQualityReportVO> result = yearlyQualityReportService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 年度质量查询分页
     * @return
     */
    @RequestMapping(value = "/yearly/page", method = RequestMethod.GET)
    @ApiOperation("年度质量查询分页")
    public ActionResult yearlyPage(@RequestBody SearchCommonVO<YearlyQualityReportVO> condition){
        PageCommonVO<YearlyQualityReportVO> result = yearlyQualityReportService.listPageDate(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 新增年度质量信息
     * @return
     */
    @RequestMapping(value = "/yearly/add", method = RequestMethod.POST)
    @ApiOperation("新增年度质量信息")
    public ActionResult yearlyAdd(@RequestBody YearlyQualityReportVO entity){
        Long result = yearlyQualityReportService.addStat(entity);
        return actionResult(result);
    }

    /**
     * 修改年度质量信息
     * @return
     */
    @RequestMapping(value = "/yearly/modify", method = RequestMethod.POST)
    @ApiOperation("修改年度质量信息")
    public ActionResult yearlyModify(@RequestBody YearlyQualityReportVO entity){
        Integer result = yearlyQualityReportService.modifyStat(entity);
        return actionResult(result);
    }

    /**
     * 等级重量及比例列表
     * @return
     */
    @RequestMapping(value = "/level/list", method = RequestMethod.GET)
    @ApiOperation("等级重量及比例列表")
    public ActionResult levelQualityList(@RequestParam Long qrId){
        LevelQualityVO entity = new LevelQualityVO();
        SearchCommonVO<LevelQualityVO> condition = new SearchCommonVO<LevelQualityVO>();
        condition.setFilters(entity);
        List<LevelQualityVO> result = levelQualityService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 新增等级重量及比例信息
     * @return
     */
    @RequestMapping(value = "/level/add", method = RequestMethod.POST)
    @ApiOperation("新增等级重量及比例信息")
    public ActionResult levelQualityAdd(@RequestBody LevelQualityVO entity){
        Long result = levelQualityService.addLevel(entity);
        return actionResult(result);
    }

    /**
     * 修改等级重量及比例信息
     * @return
     */
    @RequestMapping(value = "/level/modify", method = RequestMethod.POST)
    @ApiOperation("修改等级重量及比例信息")
    public ActionResult levelQualityModify(@RequestBody LevelQualityVO entity){
        Integer result = levelQualityService.modifyLevel(entity);
        return actionResult(result);
    }

    /**
     * 不良要因重量及比例列表
     * @return
     */
    @RequestMapping(value = "/badCause/list", method = RequestMethod.GET)
    @ApiOperation("不良要因重量及比例列表")
    public ActionResult badCauseQualityList(@RequestParam Long qrId){
        BadCauseQualityVO entity = new BadCauseQualityVO();
        SearchCommonVO<BadCauseQualityVO> condition = new SearchCommonVO<BadCauseQualityVO>();
        condition.setFilters(entity);
        List<BadCauseQualityVO> result = badCauseQualityService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 新增不良要因重量及比例信息
     * @return
     */
    @RequestMapping(value = "/badCause/add", method = RequestMethod.POST)
    @ApiOperation("新增不良要因重量及比例信息")
    public ActionResult badCauseQualityAdd(@RequestBody BadCauseQualityVO entity){
        Long result = badCauseQualityService.addCause(entity);
        return actionResult(result);
    }

    /**
     * 修改不良要因重量及比例信息
     * @return
     */
    @RequestMapping(value = "/badCause/modify", method = RequestMethod.POST)
    @ApiOperation("修改不良要因重量及比例信息")
    public ActionResult badCauseQualityModify(@RequestBody BadCauseQualityVO entity){
        Integer result = badCauseQualityService.modifyCause(entity);
        return actionResult(result);
    }

    /**
     * 重量不足的小卷重量及比例列表
     * @return
     */
    @RequestMapping(value = "/notEnough/list", method = RequestMethod.GET)
    @ApiOperation("重量不足的小卷重量及比例列表")
    public ActionResult notEnoughQualityList(@RequestParam Long qrId){
        NotEnoughQualityVO entity = new NotEnoughQualityVO();
        SearchCommonVO<NotEnoughQualityVO> condition = new SearchCommonVO<NotEnoughQualityVO>();
        condition.setFilters(entity);
        List<NotEnoughQualityVO> result = notEnoughQualityService.listAllDate(condition);
        return actionResult(result);
    }

    /**
     * 新增不良要因重量及比例信息
     * @return
     */
    @RequestMapping(value = "/notEnough/add", method = RequestMethod.POST)
    @ApiOperation("新增重量不足的小卷重量及比例信息")
    public ActionResult notEnoughQualityAdd(@RequestBody NotEnoughQualityVO entity){
        Long result = notEnoughQualityService.addQuality(entity);
        return actionResult(result);
    }

    /**
     * 修改重量不足的小卷重量及比例信息
     * @return
     */
    @RequestMapping(value = "/notEnough/modify", method = RequestMethod.POST)
    @ApiOperation("修改重量不足的小卷重量及比例信息")
    public ActionResult notEnoughQualityModify(@RequestBody NotEnoughQualityVO entity){
        Integer result = notEnoughQualityService.modifyQuality(entity);
        return actionResult(result);
    }
}
