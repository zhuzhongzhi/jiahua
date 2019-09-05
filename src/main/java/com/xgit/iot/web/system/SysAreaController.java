package com.xgit.iot.web.system;

import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.system.SysAreaService;
import com.xgit.iot.service.vo.system.SysAreaVO;
import com.bkrwin.ufast.infra.annotation.FastMappingInfo;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/SysArea")
@Api(tags = "系统管理-机构管理-地区管理")
public class SysAreaController extends BasicController {


	@Autowired
	private SysAreaService sysAreaService;

    /**
     * 详情
     * @param code
     * @return
     */
    @GetMapping("/item")
    @FastMappingInfo()
    @ApiOperation(value = "详情")
    public ActionResult item(String code){
        SysAreaVO SysAreaVO = sysAreaService.item(code);
        return actionResult(SysAreaVO);
    }

    /**
     * 列表
     * @param condition
     * @return
     */
    @PostMapping("/list")
    @FastMappingInfo()
    @ApiOperation(value = "列表")
    public ActionResult list(@RequestBody SearchCommonVO<SysAreaVO> condition){
        PageCommonVO pageCommonVO = sysAreaService.list(condition);
        return actionResult(pageCommonVO.getPageInfo());
    }

    /**
     * 新增
     * @param SysAreaVO
     * @return
     */
    @PostMapping("/insert")
    @FastMappingInfo()
    @ApiOperation(value = "新增")
    public ActionResult insert(@RequestBody SysAreaVO SysAreaVO){
        ErrorCode code = sysAreaService.insert(SysAreaVO);
        return actionResult(code);
    }

    /**
     * 更新
     * @param SysAreaVO
     * @return
     */
    @PostMapping("/update")
    @FastMappingInfo()
    @ApiOperation(value = "更新")
    public ActionResult update(@RequestBody SysAreaVO SysAreaVO){
        ErrorCode code = sysAreaService.update(SysAreaVO);
        return actionResult(code);
    }


    /**
     * 查询地址
     * @param sysAreaVO
     * @return
     */
    @PostMapping("/findAreas")
    @FastMappingInfo()
    @ApiOperation("/查询地址")
    public ActionResult findAreas(@RequestBody SysAreaVO sysAreaVO){
        if (sysAreaVO == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        List<SysAreaVO> areas = sysAreaService.findAreas(sysAreaVO);
        return actionResult(areas);
    }

}
