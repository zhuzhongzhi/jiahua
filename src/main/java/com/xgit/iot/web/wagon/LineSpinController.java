package com.xgit.iot.web.wagon;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.dao.entity.wagon.LineSpinDO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.service.vo.wagon.LineSpinVO;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import com.xgit.iot.service.vo.wagon.WagonSummaryVO;
import com.xgit.iot.service.wagon.LineSpinService;
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
@Api(tags = "线别纺位管理")
@RestController
public class LineSpinController extends BasicController{

    @Autowired
    private LineSpinService lineSpinService;

    /**
     * 新增线别纺位
     * @param entity
     * @return
     */
    @RequestMapping(value = "/lineSpin/add", method = RequestMethod.POST)
    @ApiOperation("新增线别纺位")
    public ActionResult add(@RequestBody LineSpinVO entity){
        Long lsId = lineSpinService.addLineSpin(entity);
        return actionResult(lsId);
    }

    /**
     * 新增线别纺位
     * @param entity
     * @return
     */
    @RequestMapping(value = "/lineSpin/modify", method = RequestMethod.POST)
    @ApiOperation("新增线别纺位")
    public ActionResult modify(@RequestBody LineSpinVO entity){
        Integer result = lineSpinService.modifyLineSpin(entity);
        return actionResult(result);
    }

    /**
     * 线别纺位分页查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/lineSpin/page", method = RequestMethod.POST)
    @ApiOperation("线别纺位分页查询")
    public ActionResult page(@RequestBody SearchCommonVO<LineSpinVO> condition){
        PageCommonVO result = lineSpinService.pageWithCondition(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 线别纺位列表查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/lineSpin/list", method = RequestMethod.POST)
    @ApiOperation("线别纺位列表查询")
    public ActionResult list(@RequestBody SearchCommonVO<LineSpinVO> condition){
        List<LineSpinVO> result = lineSpinService.listWithCondition(condition);
        return actionResult(result);
    }
}
