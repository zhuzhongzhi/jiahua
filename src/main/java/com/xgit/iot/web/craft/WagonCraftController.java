package com.xgit.iot.web.craft;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.service.craft.WagonExceptionService;
import com.xgit.iot.service.craft.WagonOperateService;
import com.xgit.iot.service.system.UbitraqService;
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
@RequestMapping("/produce/craft")
@Api(tags = "工艺流程管理")
@RestController
public class WagonCraftController extends BasicController{

    @Autowired
    private WagonOperateService wagonOperateService;

    @Autowired
    private WagonExceptionService wagonExceptionService;

    /**
     * 工艺流程分页查询
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("工艺流程分页查询")
    public ActionResult page(@RequestBody SearchCommonVO<WagonOperateVO> condition){
        PageCommonVO<WagonOperateVO> result = wagonOperateService.pageWagonOperate(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 工艺流程列表查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("工艺流程列表查询")
    public ActionResult list(@RequestBody SearchCommonVO<WagonOperateVO> condition){
        List<WagonOperateVO> result =  wagonOperateService.listWagonOperate(condition);
        return actionResult(result);
    }

    /**
     * 查询某条操作对应的异常记录
     * @param opId
     * @return
     */
    @RequestMapping(value = "/exceptionList", method = RequestMethod.POST)
    @ApiOperation("查询某条操作对应的异常记录")
    public ActionResult exceptionList(@RequestParam("opId") Long opId){
        List<WagonExceptionVO> voList = wagonExceptionService.listWagonOperate(opId);
        return actionResult(voList);
    }

    /**
     * 新建操作记录
     * @param info
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新建操作记录")
    public ActionResult add(@RequestBody WagonOEVO info){
        // 先增加Operate
        WagonOperateVO ov = info.getWagonOperate();
        Long opId = wagonOperateService.addOperate(ov);
        // 再增加Exception
        List<WagonExceptionVO> eList = info.getWagonExceptions();
        for (WagonExceptionVO eVO : eList){
            eVO.setOpId(opId);
            Long exId = wagonExceptionService.addException(eVO);
            eVO.setExId(exId);
        }

        return actionResult(opId);
    }

    /**
     * 修改操作记录
     * @param info
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation("修改操作记录")
    public ActionResult modify(@RequestBody WagonOEVO info){
        // 先修改Operate
        WagonOperateVO ov = info.getWagonOperate();
        int result = wagonOperateService.modifyOperate(ov);
        // 再增加Exception
        List<WagonExceptionVO> eList = info.getWagonExceptions();
        for (WagonExceptionVO eVO : eList){
            result = wagonExceptionService.modifyException(eVO);
        }
        return actionResult(result);
    }
}
