package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.IusAccountDO;
import com.xgit.iot.dao.entity.system.IusPasswordDO;
import com.xgit.iot.dao.entity.system.IusProfileDO;
import com.xgit.iot.dao.entity.system.IusUserRolesDO;
import com.xgit.iot.dao.mapper.system.IusProfileMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.util.CryptoUtil;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.IusPasswordVO;
import com.xgit.iot.service.vo.system.IusProfileVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IusProfileService extends BaseService<IusProfileVO, IusProfileDO> {

    @Autowired
    private IusProfileMapper iusProfileMapper;

    @Autowired
    private IusUserRolesService iusUserRolesService;

    @Autowired
    private IusAccountService iusAccountService;

    @Autowired
    private IusPasswordService iusPasswordService;


    @Autowired
    private GenClient genClient;

    protected IusProfileService() {
        super(IusProfileVO.class, IusProfileDO.class);
    }

    /**
     * 分页显示 有权限
     *
     * @param condition
     * @return
     */
    public PageCommonVO<IusProfileVO> list(SearchCommonVO<IusProfileVO> condition) {
        if (condition.getSort() == null || "".equals(condition.getSort())) {
            condition.setSort("pro.id asc");
        }
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new IusProfileVO());
        }
        if (StringUtils.isEmpty(condition.getFilters().getId())) {
            condition.getFilters().setId("0");
        }
        List<IusProfileVO> voList = new ArrayList<>();
        IusProfileDO infoDO = new IusProfileDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<IusProfileDO> doList = iusProfileMapper.list(infoDO);

        result.setPageInfo(new PageInfo(doList));
        return result;
    }

    /**
     * 分页显示 无权限
     *
     * @param condition
     * @return
     */
    public PageCommonVO<IusProfileVO> listAll(SearchCommonVO<IusProfileVO> condition) {
        if (condition.getSort() == null || "".equals(condition.getSort())) {
            condition.setSort("pro.id asc");
        }
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new IusProfileVO());
        }
        if (StringUtils.isEmpty(condition.getFilters().getId())) {
            condition.getFilters().setId("0");
        }
        IusProfileDO infoDO = new IusProfileDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<IusProfileDO> doList = iusProfileMapper.listAll(infoDO);
        result.setPageInfo(new PageInfo(doList));
        return result;
    }

    /**
     * 显示所有列表数据  不分页显示
     *
     * @param model
     * @return
     */
    public List<IusProfileVO> searchList(IusProfileVO model) {
        IusProfileDO infoDO = new IusProfileDO();
        BeanUtils.copyProperties(model, infoDO);
        List<IusProfileVO> voList = new ArrayList<>();
        List<IusProfileDO> doList = iusProfileMapper.searchList(infoDO);

        return voList;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public IusProfileVO select(String id) {
        IusProfileDO source = iusProfileMapper.select(id);
        IusProfileVO infoVO = new IusProfileVO();
        if (source != null) {
            BeanUtils.copyProperties(source, infoVO);
        }

        return infoVO;
    }


    //判断是否有用户绑定员工
    public int countForWorkPersonnel(String workPersonnelId) {
        int i = iusProfileMapper.countForWorkPersonnel(workPersonnelId);
        return i;
    }


    //根据员工信息查询用户信息id
    public String selectForWorkPersonnel(String workPersonnelId) {
        String s = iusProfileMapper.selectForWorkPersonnl(workPersonnelId);
        return s;
    }




    /**
     * 批量逻辑删除
     *
     * @param ids
     * @return
     */
    @Transactional
    public ErrorCode remove(List<String> ids) {
        if (iusProfileMapper.remove(ids) <= 0) {
            return ErrorCode.DeleteIusProfileFailure;
        }
        if (iusUserRolesService.remove(ids) <= 0) {
            return ErrorCode.DeleteIusUserRolesFailure;
        }
        if (iusAccountService.remove(ids) <= 0) {
            return ErrorCode.DeleteIusAccountFailure;
        }
        if (iusPasswordService.remove(ids) <= 0) {
            return ErrorCode.DeleteIusPasswordFailure;
        }
        return ErrorCode.Success;
    }


    /**
     * 更新
     *
     * @param model
     * @return
     */
    @Transactional
    public ErrorCode update(IusProfileVO model) {
        IusProfileDO entity = new IusProfileDO();
        BeanUtils.copyProperties(model, entity);


        //封装IusUserRolesDO
        IusUserRolesDO iusUserRolesDO = new IusUserRolesDO();
        iusUserRolesDO.setUserId(model.getId());
        iusUserRolesDO.setRoleId(model.getIusUserRolesDO().getRoleId());
        iusUserRolesDO.setRoleFlag(model.getIusUserRolesDO().getRoleFlag());



        //封装IusAccountDO
        IusAccountDO iusAccountDO = new IusAccountDO();
        iusAccountDO.setUserId(model.getId());
        iusAccountDO.setLoginName(model.getEmail());
        iusAccountDO.setUpdateTime(new Date());

        //更新用户资料表
        if (iusProfileMapper.update(entity) == 0) {
            return ErrorCode.IusProfileUpdateFailure;
        }

        //更新用户角色关系表信息
        if (!(iusUserRolesDO.getRoleId().toString()).equals((iusUserRolesService.select(iusUserRolesDO.getUserId())).getRoleId().toString())) {
            //更新信息
            if (iusUserRolesService.updateForUser(iusUserRolesDO) == 0) {
                return ErrorCode.IusUserRolesUpdateFailure;
            }
        }

        //更新账号信息表
        if (!(iusAccountDO.getLoginName().toString()).equals((iusAccountService.select(iusAccountDO.getUserId())).getLoginName().toString())) {
            //更新信息
            if (iusAccountService.updateForUser(iusAccountDO) == 0) {
                return ErrorCode.IusAccountUpdateFailure;
            }
        }
        return ErrorCode.Success;
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @Transactional
    public ErrorCode add(IusProfileVO model) throws Exception {
        //添加id
        model.setId(genClient.newGuidText().getValue());
        model.setSpaceId("100000");
        IusProfileDO entity = new IusProfileDO();
        BeanUtils.copyProperties(model, entity);

        //封装IusUserRolesDO
        IusUserRolesDO iusUserRolesDO = new IusUserRolesDO();
        iusUserRolesDO.setUserId(model.getId());
        iusUserRolesDO.setRoleId(model.getIusUserRolesDO().getRoleId());
        iusUserRolesDO.setRoleFlag(model.getIusUserRolesDO().getRoleFlag());

        entity.setName(model.getEmail());

        //封装IusAccountDO
        IusAccountDO iusAccountDO = new IusAccountDO();
        iusAccountDO.setUserId(model.getId());
        iusAccountDO.setLoginName(model.getEmail());
        iusAccountDO.setCreateTime(new Date());
//        iusAccountDO.setStatus(model.getIusAccountDO().getStatus());
        iusAccountDO.setUpdateTime(new Date());
        iusAccountDO.setStatus(new Double(0));

        //封装IusPasswordDO
        IusPasswordDO passwordDO = new IusPasswordDO();
        passwordDO.setUserId(model.getId());
        passwordDO.setPassword("123456");
        String cypherPassword = cryptoPassword(passwordDO.getPassword(), passwordDO.getUserId());
        passwordDO.setPassword(cypherPassword);
        passwordDO.setUpdateTime(new Date());


        //添加用户资料表的信息
        if (iusProfileMapper.add(entity) == 0) {
            return ErrorCode.IusProfileInsertFailure;
        }
        //添加用户角色关系的信息
        if (iusUserRolesService.add(iusUserRolesDO) == 0) {
            return ErrorCode.IusUserRolesInsertFailure;
        }
        //添加账号信息表的信息
        if (iusAccountService.add(iusAccountDO) == 0) {
            return ErrorCode.IusAccountInsertFailure;
        }
        if (iusPasswordService.add(passwordDO) == 0) {
            return ErrorCode.IusPasswordInsertFailure;
        }
        return ErrorCode.Success;
    }


    //密码加密
    private String cryptoPassword(String text, String salt) throws Exception {
        String orginalText = text + "_" + salt;
        byte[] cypherBytes = CryptoUtil.encryptMD5(orginalText.getBytes());
        String cypherText = new BigInteger(cypherBytes).toString(16);
        return cypherText;
    }


    public ErrorCode updatePassword(IusPasswordVO model) throws Exception {
        IusPasswordDO iusPasswordDO = new IusPasswordDO();
        BeanUtils.copyProperties(model, iusPasswordDO);

        String cypherPassword = cryptoPassword(iusPasswordDO.getPassword(), iusPasswordDO.getUserId());
        iusPasswordDO.setPassword(cypherPassword);
        iusPasswordDO.setUpdateTime(new Date());
        if (iusPasswordService.updateForUser(iusPasswordDO) == 0) {
            return ErrorCode.Failure;
        }
        return ErrorCode.Success;

    }

    // 获取用户注册控制
    public boolean getShowRegister() {
        return iusProfileMapper.getShowRegister() == 1;
    }

    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    public IusProfileVO getProfileByUserId(String userId) {
        IusProfileVO result = new IusProfileVO();
        if (StringUtils.isEmpty(userId)) {
            return result;
        }
        BeanUtils.copyProperties(this.iusProfileMapper.getUserProfileById(userId), result);
        return result;
    }
}
