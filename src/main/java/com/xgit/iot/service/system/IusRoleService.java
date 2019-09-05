package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.IusRoleDO;
import com.xgit.iot.dao.mapper.system.IusRoleMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.IusRoleVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IusRoleService extends BaseService<IusRoleVO,IusRoleDO> {

    @Autowired
    private IusRoleMapper iusRoleMapper;

    @Autowired
    private GenClient genClient;

    protected IusRoleService() {
        super(IusRoleVO.class, IusRoleDO.class);
    }


    /**
     * 分页显示 有权限
     * @param condition
     * @return
     */
    public PageCommonVO<IusRoleVO> listRoles(SearchCommonVO<IusRoleVO> condition) {
        if (condition.getSort() == null || "".equals(condition.getSort())){
            condition.setSort("role.id asc");
        }
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null){
            condition.setFilters(new IusRoleVO());
        }
        if (StringUtils.isEmpty(condition.getFilters().getId())){
            condition.getFilters().setId("0");
        }
        List<IusRoleVO> voList = new ArrayList<>();
        IusRoleDO infoDO = new IusRoleDO();
        BeanUtils.copyProperties(condition.getFilters(),infoDO);
        List<IusRoleDO> doList = iusRoleMapper.listRoles(infoDO);
        for (IusRoleDO e : doList){
            IusRoleVO model = new IusRoleVO();
            BeanUtils.copyProperties(e,model);
            voList.add(model);
        }
        result.setPageInfo(new PageInfo(doList));
        result.setPageInfoList(voList);
        return result;
    }



    /**
     * 分页显示 无权限
     * @param condition
     * @return
     */
    public PageCommonVO<IusRoleVO> searchListRoles(SearchCommonVO<IusRoleVO> condition){
        if (condition.getSort() == null || "".equals(condition.getSort())){
            condition.setSort("role.id asc");
        }
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null){
            condition.setFilters(new IusRoleVO());
        }
        if (StringUtils.isEmpty(condition.getFilters().getId())){
            condition.getFilters().setId("0");
        }
        IusRoleDO infoDO = new IusRoleDO();
        BeanUtils.copyProperties(condition.getFilters(),infoDO);
        List<IusRoleDO> doList = iusRoleMapper.searchListRoles(infoDO);
        result.setPageInfo(new PageInfo(doList));
        return result;
    }


    /**
     * 显示所有的role  给用户管理界面使用  不分页
     * @param model
     * @return
     */
    public List<IusRoleVO> listAllRoles(IusRoleVO model){
        IusRoleDO iusRoleDO = new IusRoleDO();
        BeanUtils.copyProperties(model,iusRoleDO);
        List<IusRoleDO> iusRoleDOS = iusRoleMapper.listAllRoles(iusRoleDO);
        List<IusRoleVO> iusRoleVOS = new ArrayList<>();
        for (IusRoleDO roleDO : iusRoleDOS){
            IusRoleVO roleVO = new IusRoleVO();
            BeanUtils.copyProperties(roleDO,roleVO);
            iusRoleVOS.add(roleVO);
        }
        return iusRoleVOS;
    }
}
