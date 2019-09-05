package com.xgit.iot.web.system;

import com.bkrwin.ufast.dto.UserDetailDTO;
import com.bkrwin.ufast.infra.annotation.FastMappingInfo;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.system.SysCompanyService;
import com.xgit.iot.service.system.SysCompanyUserService;
import com.xgit.iot.service.vo.system.SysCompanyUserVO;
import com.xgit.iot.service.vo.system.SysCompanyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author chenwei
 * @email  chenwei@bkrwin.com
 * @date   2018-11-21 13:42:58
 */
@RestController
@RequestMapping("/SysCompany")
@Api(tags = "系统管理-机构管理")
public class SysCompanyController extends BasicController {
	@Autowired
	private SysCompanyService sysCompanyService;

	@Autowired
    private SysCompanyUserService sysCompanyUserService;
    /**
     * 详情
     */
    @ApiOperation(value = "公司详情")
    @RequestMapping(value = "/item",method = RequestMethod.GET)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.QUERY)
    public ActionResult item(String orgId){
        SysCompanyUserVO sysCompanyUserDO = sysCompanyUserService.select(orgId);
        return actionResult(sysCompanyUserDO);
    }

    /**
     * 显示机构分页列表-有权限控制
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.QUERY)
    @ApiOperation(value = "显示机构分页列表-有权限控制")
    public ActionResult list(@RequestBody SearchCommonVO<SysCompanyUserVO> condition){
        if (condition == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        PageCommonVO pageCommonVO=sysCompanyUserService.list(condition);
        return actionResult(pageCommonVO.getPageInfo());
    }

    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.VehicleMonitor.PlaceDisposition.QUERY)
    @ApiOperation("获取所有机构列表")
    public ActionResult searchList(@RequestBody SysCompanyVO condition) {

        List<SysCompanyVO> result =sysCompanyService.searchList(condition);
        return actionResult(result);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/insertCompany",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.ADD)
    @FastMappingInfo(needLogin = true)
    public ActionResult insertCompany(@RequestBody SysCompanyVO sysCompanyVO)throws Exception{
        UserDetailDTO userDetailDTO = getUserDetail();
        if(userDetailDTO == null){
            return actionResult(ErrorCode.NeedLogin);
        }
        ErrorCode code = sysCompanyService.insertCompany(sysCompanyVO,userDetailDTO);
        return actionResult(code);
    }

    /**
     * 更新
     */
    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateCompany",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.EDIT)
    @FastMappingInfo(needLogin = true)
    public ActionResult updateCompany(@RequestBody SysCompanyVO sysCompanyVO){
        UserDetailDTO userDetailDTO = getUserDetail();
        if(userDetailDTO == null){
            return actionResult(ErrorCode.NeedLogin);
        }
        ErrorCode code=sysCompanyService.update(sysCompanyVO,userDetailDTO);
        return actionResult(code);
    }

    /**
     * 停用启用
     */
    @ApiOperation(value = "停用启用")
    @RequestMapping(value = "/enableCompany",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.EDIT)
    @FastMappingInfo(needLogin = true)
    public ActionResult enableCompany(@RequestBody SysCompanyVO sysCompanyVO){

        if(sysCompanyVO == null){
            return actionResult(ErrorCode.IllegalArument);
        }

        ErrorCode code=sysCompanyService.enable(sysCompanyVO.getOrgId(),sysCompanyVO.getEnabled());
        return actionResult(code);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.REMOVE)
    @FastMappingInfo(needLogin = true)
    public ActionResult deleteCompany(@RequestBody String orgId){
        if(StringUtils.isEmpty(orgId)){
            return actionResult(ErrorCode.IllegalArument);
        }

        ErrorCode code=sysCompanyService.delete(orgId);
        return actionResult(code);
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除")
    @RequestMapping(value = "/batchDeleteCompany",method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true,code = AuthCode.SystemManage.Company.REMOVE)
    @FastMappingInfo(needLogin = true)
    public ActionResult batchDeleteCompany(@RequestBody List<String> orgIdList){
        if(orgIdList == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        ErrorCode code = sysCompanyService.batchDeleteCompany(orgIdList);
        return actionResult(code);
    }


    /**
     * 递归查询机构
     * @return
     */
    @PostMapping("/searchForCompany")
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.Company.QUERY)
    @ApiOperation("递归查询机构")
    public ActionResult searchForCompany(){
        List<Map> companys = sysCompanyService.findCompanys();
        return actionResult(companys);
    }

    /**
     * 递归查询父机构ids
     * @return
     */
    @GetMapping("/getParentIds")
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.Company.QUERY)
    @ApiOperation("递归查询父机构ids")
    public ActionResult getParentIds(@RequestParam("orgId") String orgId){

        String parentIds = sysCompanyService.findParentIds(orgId, "");
        // 去掉最后的，
        return actionResult(parentIds.substring(0, parentIds.length() - 1));
    }

    /**
     * 递归查询子机构ids
     * @return
     */
    @GetMapping("/getChildIds")
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.Company.QUERY)
    @ApiOperation("递归查询子机构ids")
    public ActionResult getChildIds(@RequestParam("orgId") String orgId){

        String childIds = sysCompanyService.findChildIds(orgId);

        return actionResult(childIds);
    }




    /**
     * 递归查询机构，并过滤没有车辆信息的机构
     * @return
     */
    @PostMapping("/findCompanysFilter")
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.Company.QUERY)
    @ApiOperation("递归查询机构，并过滤没有车辆信息的机构")
    public ActionResult findCompanysFilter(){
        List<Map> companys = sysCompanyService.findCompanysFilter();
        return actionResult(companys);
    }




}
