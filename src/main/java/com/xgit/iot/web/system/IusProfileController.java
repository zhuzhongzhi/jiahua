package com.xgit.iot.web.system;

import com.bkrwin.ufast.infra.annotation.FastMappingInfo;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.system.IusProfileService;
import com.xgit.iot.service.vo.system.IusPasswordVO;
import com.xgit.iot.service.vo.system.IusProfileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 系统管理-用户管理
 */
@RequestMapping("/iusProfile")
@Api(tags = "系统管理-用户管理")
@RestController
public class IusProfileController extends BasicController{

    @Autowired
    private IusProfileService iusProfileService;

    /**
     * 显示用户分页列表 -有权限控制
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.QUERY)
    @ApiOperation("显示用户分页列表-有权限控制")
    public ActionResult list(@RequestBody SearchCommonVO<IusProfileVO> condition){
//        if (condition == null){
//            return actionResult(ErrorCode.IllegalArument);
//        }
        PageCommonVO result = iusProfileService.list(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 显示用户分页列表 -无权限控制
     * @param condition
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ApiOperation("显示用户分页列表-无权限控制")
    public ActionResult listALl(@RequestBody SearchCommonVO<IusProfileVO> condition){
        PageCommonVO result = iusProfileService.listAll(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 显示用户所有的数据列表-有权限
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.QUERY)
    @ApiOperation("显示用户所有的数据列表-有权限")
    public ActionResult searchList(@RequestBody IusProfileVO model){
        if (model == null){
            model = new IusProfileVO();
        }
        List<IusProfileVO> result = iusProfileService.searchList(model);
        return actionResult(result);
    }


    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.QUERY)
    @ApiOperation("查询用户信息")
    public ActionResult search(@RequestParam String id){
        if (id == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        IusProfileVO result = iusProfileService.select(id);
        return actionResult(result);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/searchById", method = RequestMethod.GET)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.QUERY)
    @ApiOperation("查询用户信息")
    public ActionResult searchById(@RequestParam String id){
        if (id == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        IusProfileVO result = iusProfileService.select(id);
        return actionResult(result);
    }

    /**
     * 获取员工信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.QUERY)
    @ApiOperation("获取员工信息")
    public ActionResult getById(@RequestParam String id){
        if (id == null){
            return actionResult(ErrorCode.IllegalArument);
        }

        return actionResult("yes");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.REMOVE)
    @ApiOperation("删除用户信息")
    @FastMappingInfo(needLogin = true)
    public ActionResult remove(@RequestBody List<String> ids) {
        if (ids == null) {
            return actionResult(ErrorCode.IllegalArument);
        }
        ErrorCode result = iusProfileService.remove(ids);
        return actionResult(result);
    }


    /**
     * 更新
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.EDIT)
    @ApiOperation("修改用户信息")
    @FastMappingInfo(needLogin = true)
    public ActionResult update(@RequestBody IusProfileVO model) {
        if (model == null) {
            return actionResult(ErrorCode.IllegalArument);
        }
        ErrorCode result = iusProfileService.update(model);
        return actionResult(result);
    }

    /**
     * 新增
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.ADD)
    @ApiOperation("新增用户信息")
    @FastMappingInfo(needLogin = true)
    public ActionResult add(@RequestBody IusProfileVO model) throws Exception {
        if (model == null){
            return actionResult(ErrorCode.IllegalArument);
        }
        //添加创建人信息
        model.setCreateDate(new Date());
        ErrorCode result = iusProfileService.add(model);
        return actionResult(result);
    }

    /**
     * 修改用户密码
     * @param model
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//    @FastMappingInfo(needLogin = true, code = AuthCode.SystemManage.IusProfile.EDIT)
    @ApiOperation("修改用户密码")
    @FastMappingInfo(needLogin = true)
    public ActionResult updatePassword(@RequestBody IusPasswordVO model) throws Exception {
        if (model == null) {
            return actionResult(ErrorCode.IllegalArument);
        }
        ErrorCode result = iusProfileService.updatePassword(model);
        return actionResult(result);

    }

    /**
     * 查询app用户注册是否显示
     * @return
     */
    @RequestMapping(value = "/getShowRegister", method = RequestMethod.GET)
    @ApiOperation("查询app用户注册是否显示")
    public ActionResult getShowRegister(){

        boolean result = iusProfileService.getShowRegister();
        return actionResult(result);
    }

}
