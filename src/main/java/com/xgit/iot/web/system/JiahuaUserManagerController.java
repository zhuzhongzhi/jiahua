package com.xgit.iot.web.system;

import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.dao.entity.system.AopEntity;
import com.xgit.iot.infra.BasicController;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.system.*;
import com.xgit.iot.service.vo.system.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/jiahua/user")
@Api(tags = "嘉华用户管理")
@Slf4j
public class JiahuaUserManagerController extends BasicController {

    /*@Autowired
    private IusProfileService iusProfileService;

    @Autowired
    private IusAccountService iusAccountService;

    *//**
     * 查询用户账户信息
     * @param condition
     * @return
     *//*
    @RequestMapping(value = "/userPage", method = RequestMethod.POST)
    @ApiOperation("查询用户账户信息")
    public ActionResult userPage(@RequestBody SearchCommonVO<IusAccountVO> condition){
        PageCommonVO result = iusAccountService.listWithCondition(condition);
        return actionResult(result.getPageInfo());
    }

    *//**
     * 修改用户账户信息
     * @param entity
     * @return
     *//*
    @RequestMapping(value = "/userModify", method = RequestMethod.POST)
    @ApiOperation("修改用户账户信息")
    public ActionResult userModify(@RequestBody IusAccountVO entity){
        Integer result = iusAccountService.modifyAccount(entity);
        return actionResult(result);
    }

    *//**
     * 新增用户账户信息
     * @param entity
     * @return
     *//*
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    @ApiOperation("新增用户账户信息")
    public ActionResult userAdd(@RequestBody IusAccountVO entity){
        // 需要新增默认的ius_profile信息
        ErrorCode result = ErrorCode.Success;
        try {
            result = iusProfileService.userAdd(entity);
        } catch (Exception e){
            e.printStackTrace();
        }
        return actionResult(result);
    }*/

    @Autowired
    private JiahuaUserService jiahuaUserService;

    @Autowired
    private JiahuaAuthService jiahuaAuthService;

    @Autowired
    private JiahuaUserAuthService jiahuaUserAuthService;

    @Autowired
    private AopEntityService aopEntityService;
    /**
     * 查询用户账户信息
     * @param condition
     * @return
     */
    @RequestMapping(value = "/userPage", method = RequestMethod.POST)
    @ApiOperation("查询用户账户信息")
    public ActionResult userPage(@RequestBody SearchCommonVO<JiahuaUserVO> condition){
        PageCommonVO result = jiahuaUserService.pageWithCondition(condition);
        return actionResult(result.getPageInfo());
    }
    /**
     * 修改用户账户信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/userModify", method = RequestMethod.POST)
    @ApiOperation("修改用户账户信息")
    public ActionResult userModify(@RequestBody JiahuaUserVO entity){
        Integer result = jiahuaUserService.modifyUser(entity);
        return actionResult(result);
    }

    /**
     * 新增用户账户信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    @ApiOperation("新增用户账户信息")
    public ActionResult userAdd(@RequestBody JiahuaUserVO entity){
        // 需要新增默认的ius_profile信息
        Long id = jiahuaUserService.addUser(entity);
        return actionResult(id);
    }

    /**
     * 查询用户账户信息
     * @param condition
     * @return
     */
    @RequestMapping(value = "/authPage", method = RequestMethod.POST)
    @ApiOperation("查询用户账户信息")
    public ActionResult authPage(@RequestBody SearchCommonVO<JiahuaAuthVO> condition){
        PageCommonVO result = jiahuaAuthService.pageWithCondition(condition);
        return actionResult(result.getPageInfo());
    }
    /**
     * 修改权限信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/authModify", method = RequestMethod.POST)
    @ApiOperation("修改权限信息")
    public ActionResult authModify(@RequestBody JiahuaAuthVO entity){
        Integer result = jiahuaAuthService.modifyAuth(entity);
        return actionResult(result);
    }

    /**
     * 新增权限信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/authAdd", method = RequestMethod.POST)
    @ApiOperation("新增权限信息")
    public ActionResult authAdd(@RequestBody JiahuaAuthVO entity){
        // 需要新增默认的ius_profile信息
        Long id = jiahuaAuthService.addAuth(entity);
        return actionResult(id);
    }

    /**
     * 查询用户账户信息
     * @param condition
     * @return
     */
    @RequestMapping(value = "/userAuthPage", method = RequestMethod.POST)
    @ApiOperation("查询用户账户信息")
    public ActionResult userAuthPage(@RequestBody SearchCommonVO<JiahuaUserAuthVO> condition){
        PageCommonVO result = jiahuaUserAuthService.pageWithCondition(condition);
        return actionResult(result.getPageInfo());
    }
    /**
     * 修改权限信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/userAuthModify", method = RequestMethod.POST)
    @ApiOperation("修改权限信息")
    public ActionResult userAuthModify(@RequestBody JiahuaUserAuthVO entity){
        Integer result = jiahuaUserAuthService.modifyUserAuth(entity);
        return actionResult(result);
    }

    /**
     * 新增权限信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/userAuthAdd", method = RequestMethod.POST)
    @ApiOperation("新增权限信息")
    public ActionResult userAuthAdd(@RequestBody JiahuaUserAuthVO entity){
        // 需要新增默认的ius_profile信息
        Long id = jiahuaUserAuthService.addUserAuth(entity);
        return actionResult(id);
    }

    /**
     * 用户登录
     * @param loginVO
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("用户登录")
    public ResponseEntity<?> login(HttpServletRequest httpServletRequest, @RequestBody LoginVO loginVO){

        JiahuaUserVO jiahuaUserVO = jiahuaUserService.selectByUserName(loginVO.getUserName());
        if (jiahuaUserVO == null){
            // 用户不存在
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User not exist!");
        } else {
            // 对比密码
            if (loginVO.getPassword().equals(jiahuaUserVO.getPassword())){
                // 设置认证成功，增加头部信息
                String token = loginVO.getUserName() + ":" + loginVO.getPassword();
                String tokenBase64 = null;
                try {
                    tokenBase64 = Base64.getEncoder().encodeToString(token.getBytes("UTF-8"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                String basicValue = "Basic " + tokenBase64;
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Authorization", basicValue);
                return new ResponseEntity<>(basicValue, httpHeaders, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Password error!");
            }
        }
    }

    /**
     * 获取登录信息
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/getLogin", method = RequestMethod.POST)
    @ApiOperation("获取登录信息")
    public ActionResult getLogin(HttpServletRequest httpServletRequest){
        String value = httpServletRequest.getHeader("Authorization");
        if (value != null){
            String[] tokens = value.split(" ");
            if (tokens[0].equals("Basic")){
                byte[] decoded = Base64.getDecoder().decode(tokens[1]);
                String decodeStr = new String(decoded);
                String[] infos = decodeStr.split(":");
                String userName = infos[0];
                String password = infos[1];

                //获取用户信息以及用户权限信息
                UserInfoVO userInfoVO = new UserInfoVO();
                JiahuaUserVO jiahuaUserVO = jiahuaUserService.selectByUserName(userName);
                if (jiahuaUserVO != null) {
                    if (password.equals(jiahuaUserVO.getPassword())) {
                        userInfoVO.setJiahuaUser(jiahuaUserVO);

                        // 查询用户权限
                        SearchCommonVO<JiahuaUserAuthVO> condition = new SearchCommonVO<JiahuaUserAuthVO>();
                        condition.setPageNum(1);
                        condition.setPageSize(99999);
                        JiahuaUserAuthVO filter = new JiahuaUserAuthVO();
                        filter.setUserId(jiahuaUserVO.getUserId());
                        condition.setFilters(filter);
                        List<JiahuaUserAuthVO> userAuthList = jiahuaUserAuthService.listWithCondition(condition);
                        userInfoVO.setJiahuaUserAuthList(userAuthList);

                        return actionResult(userInfoVO);
                    }
                }
            }
        }

        return actionResult(ErrorCode.CheckLoginFailure);
    }

    /**
     * 查询系统操作日志信息
     * @param condition
     * @return
     */
    @RequestMapping(value = "/operateLog", method = RequestMethod.POST)
    @ApiOperation("查询系统操作日志信息")
    public ActionResult operateLog(@RequestBody SearchCommonVO<AopEntity> condition){
        PageCommonVO result = aopEntityService.pageWithCondition(condition);
        return actionResult(result.getPageInfo());
    }

    /**
     * 查询系统操作日志信息所有满足条件的
     * @param condition
     * @return
     */
    @RequestMapping(value = "/operateLogAll", method = RequestMethod.POST)
    @ApiOperation("查询系统操作日志信息")
    public ActionResult operateLogAll(@RequestBody SearchCommonVO<AopEntity> condition){
        List<AopEntity> result = aopEntityService.listWithCondition(condition);
        return actionResult(result);
    }

    /**
     * 清除系统操作日志信息
     * @return
     */
    @RequestMapping(value = "/clearOperateLog", method = RequestMethod.POST)
    @ApiOperation("清除系统操作日志信息")
    public ActionResult clearOperateLog(){
        Integer result = aopEntityService.clear();
        return actionResult(result);
    }

    /**
     * 删除系统操作日志信息
     * @return
     */
    @RequestMapping(value = "/delOperateLog", method = RequestMethod.POST)
    @ApiOperation("删除系统操作日志信息")
    public ActionResult delOperateLog(@RequestBody List<Long> ids){
        Integer result = aopEntityService.remove(ids);
        return actionResult(result);
    }
}
