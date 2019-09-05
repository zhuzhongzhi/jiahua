package com.xgit.iot.web.system;

import com.bkrwin.ufast.infra.annotation.FastMappingInfo;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.AuthCode;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.system.IusRoleService;
import com.xgit.iot.service.vo.system.IusRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 系统管理-角色管理
 */
@RequestMapping("/iusRole")
@Api(tags = "系统管理-角色管理")
@RestController
public class IusRoleController extends BasicController{

    @Autowired
    private IusRoleService iusRoleService;


    /**
     * 显示所有的role  给用户管理界面使用 分页
     * @param condition
     * @return
     */
    @RequestMapping(value = "/listRoles", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusRole.QUERY)
    @ApiOperation("显示所有的role  给用户管理界面使用 分页")
    public ActionResult listRoles(@RequestBody SearchCommonVO<IusRoleVO> condition){
        if (condition == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        PageCommonVO result = iusRoleService.listRoles(condition);
        return actionResult(result.getPageInfo());
    }


    /**
     * 显示所有的role  给用户管理界面使用 分页 无权限
     * @param condition
     * @return
     */
    @RequestMapping(value = "/searchListRoles", method = RequestMethod.POST)
    @ApiOperation("显示所有的role  给用户管理界面使用 分页 无权限")
    public ActionResult searchListRoles(@RequestBody SearchCommonVO<IusRoleVO> condition){
        PageCommonVO result = iusRoleService.searchListRoles(condition);
        return actionResult(result.getPageInfo());
    }


    /**
     * 显示所有的role  给用户管理界面使用  不分页  searchListRoles
     * @param model
     * @return
     */
    @RequestMapping(value = "/listAllRoles", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusRole.QUERY)
    @ApiOperation("显示所有的role  给用户管理界面使用  不分页")
    public ActionResult listAllRoles(@RequestBody IusRoleVO model){
        if (model == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        List<IusRoleVO> iusRoleVOS = iusRoleService.listAllRoles(model);
        return actionResult(iusRoleVOS);
    }



}
