package com.xgit.iot.web.warn;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.craft.WagonExceptionService;
import com.xgit.iot.service.craft.WagonOperateService;
import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOEVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import com.xgit.iot.service.vo.warn.*;
import com.xgit.iot.service.warn.AlarmHandleLogService;
import com.xgit.iot.service.warn.LineAlarmService;
import com.xgit.iot.service.warn.ResidentAlarmService;
import com.xgit.iot.service.warn.SpinAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 报警管理
 */
@RequestMapping("/warn")
@Api(tags = "报警管理")
@RestController
public class WagonWarnController extends BasicController{

    @Autowired
    private LineAlarmService lineAlarmService;

    @Autowired
    private SpinAlarmService spinAlarmService;

    @Autowired
    private ResidentAlarmService residentAlarmService;

    @Autowired
    private AlarmHandleLogService alarmHandleLogService;

    /**
     * 实时告警查询
     * @return
     */
    @RequestMapping(value = "/realtime/list", method = RequestMethod.GET)
    @ApiOperation("实时告警查询")
    public ActionResult realTimeAlarmList(){
        RealTimeAlarmVO vo = new RealTimeAlarmVO();
        vo.setSpinAlarmS(spinAlarmService.listCurDate());
        vo.setResidentAlarmS(residentAlarmService.listCurDate());
        return actionResult(vo);
    }

    /**
     * 新增锭位质量告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/spin/add", method = RequestMethod.POST)
    @ApiOperation("新增锭位质量告警")
    public ActionResult spinAdd(@RequestBody SpinAlarmVO info){
        Long alarmId = spinAlarmService.addAlarm(info);
        return actionResult(alarmId);
    }

    /**
     * 修改锭位质量告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/spin/modify", method = RequestMethod.POST)
    @ApiOperation("修改锭位质量告警")
    public ActionResult spinModify(@RequestBody SpinAlarmVO info){
        Integer result = spinAlarmService.modifyAlarm(info);
        return actionResult(result);
    }

    /**
     * 锭位质量告警查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/spin/page", method = RequestMethod.POST)
    @ApiOperation("锭位质量告警查询")
    public ActionResult spinPage(@RequestBody SearchCommonVO<SpinAlarmVO> condition){
        PageCommonVO<SpinAlarmVO> result = spinAlarmService.page(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 处理锭位质量告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/spin/deal", method = RequestMethod.POST)
    @ApiOperation("查询某条操作对应的异常记录")
    public ActionResult spinDeal(@RequestBody SpinDealVO info){
        if ((info == null) || (info.getSpinAlarm() == null) || (info.getSpinAlarm().getAlarmId() == null)) {
            //数据错误
            return actionResult(ErrorCode.Failure, -3);
        }
        SpinAlarmVO dbVO = spinAlarmService.getById(info.getSpinAlarm().getAlarmId());
        if (dbVO == null){
            //记录不存在
            return actionResult(ErrorCode.Failure, -1);
        }
        if ((dbVO.getIsHandled() == null) ||(dbVO.getIsHandled() != 0)){
            //记录不存在，或者已经被处理过了
            return actionResult(ErrorCode.Failure,-2);
        }

        AlarmHandleLogVO logVO = new AlarmHandleLogVO();
        SpinAlarmVO spinAlarmVO = info.getSpinAlarm();
        logVO.setAlarmId(spinAlarmVO.getAlarmId());
        logVO.setAlarmType(spinAlarmVO.getAlarmType());
        logVO.setBatchNum(spinAlarmVO.getBatchNum());
        logVO.setLineType(spinAlarmVO.getLineType());
        logVO.setStandard(spinAlarmVO.getStandard());
        logVO.setCardTime(spinAlarmVO.getAlarmTime());
        logVO.setHandleTime(new Date());
        logVO.setOperator(info.getOperator());
        logVO.setRemark(info.getRemark());

        logVO.setHandleId(alarmHandleLogService.addAlarm(logVO));

        // 更新告警信息，修改is_handled为1
        spinAlarmVO.setIsHandled(1);
        int result = spinAlarmService.modifyAlarm(spinAlarmVO);
        return actionResult(result);
    }

    /**
     * 新增驻留告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/resident/add", method = RequestMethod.POST)
    @ApiOperation("新增驻留告警")
    public ActionResult residentAdd(@RequestBody ResidentAlarmVO info){
        Long alarmId = residentAlarmService.addAlarm(info);
        return actionResult(alarmId);
    }

    /**
     * 修改驻留告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/resident/modify", method = RequestMethod.POST)
    @ApiOperation("修改驻留告警")
    public ActionResult residentModify(@RequestBody ResidentAlarmVO info){
        Integer result = residentAlarmService.modifyAlarm(info);
        return actionResult(result);
    }

    /**
     * 驻留告警查询分页
     * @param condition
     * @return
     */
    @RequestMapping(value = "/resident/page", method = RequestMethod.POST)
    @ApiOperation("驻留告警查询分页")
    public ActionResult residentPage(@RequestBody SearchCommonVO<ResidentAlarmVO> condition){
        PageCommonVO<ResidentAlarmVO> result = residentAlarmService.page(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 处理驻留告警信息
     * @param info
     * @return
     */
    @RequestMapping(value = "/resident/deal", method = RequestMethod.POST)
    @ApiOperation("处理驻留告警信息")
    public ActionResult residentDeal(@RequestBody ResidentDealVO info){
        if ((info == null) || (info.getResidentAlarm() == null) || (info.getResidentAlarm().getAlarmId() == null)) {
            //数据错误
            return actionResult(ErrorCode.Failure, -3);
        }
        ResidentAlarmVO dbVO = residentAlarmService.getById(info.getResidentAlarm().getAlarmId());
        if (dbVO == null){
            //记录不存在
            return actionResult(ErrorCode.Failure, -1);
        }
        if ((dbVO.getIsHandled() == null) ||(dbVO.getIsHandled() != 0)){
            //记录不存在，或者已经被处理过了
            return actionResult(ErrorCode.Failure,-2);
        }

        AlarmHandleLogVO logVO = new AlarmHandleLogVO();
        ResidentAlarmVO residentAlarm = info.getResidentAlarm();
        logVO.setAlarmId(residentAlarm.getAlarmId());
        logVO.setAlarmType(residentAlarm.getAlarmType());
        logVO.setBatchNum(residentAlarm.getBatchNum());
        logVO.setLineType(residentAlarm.getLineType());
        logVO.setStandard(residentAlarm.getStandard());
        logVO.setCardTime(residentAlarm.getAlarmTime());
        logVO.setHandleTime(new Date());
        logVO.setOperator(info.getOperator());
        logVO.setRemark(info.getRemark());

        logVO.setHandleId(alarmHandleLogService.addAlarm(logVO));

        // 更新告警信息，修改is_handled为1
        residentAlarm.setIsHandled(1);
        int result = residentAlarmService.modifyAlarm(residentAlarm);
        return actionResult(result);
    }

    /**
     * 新增线别质量告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/line/add", method = RequestMethod.POST)
    @ApiOperation("新增线别质量告警")
    public ActionResult lineAdd(@RequestBody LineAlarmVO info){
        Long alarmId = lineAlarmService.addAlarm(info);
        return actionResult(alarmId);
    }

    /**
     * 修改线别质量告警
     * @param info
     * @return
     */
    @RequestMapping(value = "/line/modify", method = RequestMethod.POST)
    @ApiOperation("修改线别质量告警")
    public ActionResult lineModify(@RequestBody LineAlarmVO info){
        Integer result = lineAlarmService.modifyAlarm(info);
        return actionResult(result);
    }

    /**
     * 线别质量告警查询分页
     * @param condition
     * @return
     */
    @RequestMapping(value = "/line/page", method = RequestMethod.POST)
    @ApiOperation("线别质量告警查询分页")
    public ActionResult linePage(@RequestBody SearchCommonVO<LineAlarmVO> condition){
        PageCommonVO<LineAlarmVO> result = lineAlarmService.page(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 处理线别质量告警信息
     * @param info
     * @return
     */
    @RequestMapping(value = "/line/deal", method = RequestMethod.POST)
    @ApiOperation("处理线别质量告警信息")
    public ActionResult lineDeal(@RequestBody LineDealVO info){
        if ((info == null) || (info.getLineAlarm() == null) || (info.getLineAlarm().getAlarmId() == null)) {
            //数据错误
            return actionResult(ErrorCode.Failure, -3);
        }
        LineAlarmVO dbVO = lineAlarmService.getById(info.getLineAlarm().getAlarmId());
        if (dbVO == null){
            //记录不存在
            return actionResult(ErrorCode.Failure, -1);
        }
        if ((dbVO.getIsHandled() == null) ||(dbVO.getIsHandled() != 0)){
            //记录不存在，或者已经被处理过了
            return actionResult(ErrorCode.Failure,-2);
        }
        AlarmHandleLogVO logVO = new AlarmHandleLogVO();
        LineAlarmVO lineAlarm = info.getLineAlarm();
        logVO.setAlarmId(lineAlarm.getAlarmId());
        logVO.setAlarmType(lineAlarm.getAlarmType());
        logVO.setBatchNum(lineAlarm.getBatchNum());
        logVO.setLineType(lineAlarm.getLineType());
        logVO.setStandard(lineAlarm.getStandard());
        logVO.setCardTime(lineAlarm.getAlarmTime());
        logVO.setHandleTime(new Date());
        logVO.setOperator(info.getOperator());
        logVO.setRemark(info.getRemark());

        logVO.setHandleId(alarmHandleLogService.addAlarm(logVO));

        // 更新告警信息，修改is_handled为1
        lineAlarm.setIsHandled(1);
        int result = lineAlarmService.modifyAlarm(lineAlarm);
        return actionResult(logVO.getHandleId());
    }

    /**
     * 告警处理日志查询分页
     * @param condition
     * @return
     */
    @RequestMapping(value = "/handle/page", method = RequestMethod.POST)
    @ApiOperation("告警处理日志查询分页")
    public ActionResult handlePage(@RequestBody SearchCommonVO<AlarmHandleLogVO> condition){
        PageCommonVO<AlarmHandleLogVO> result = alarmHandleLogService.page(condition);
        return actionResult(result.getPageInfo());
    }
}
