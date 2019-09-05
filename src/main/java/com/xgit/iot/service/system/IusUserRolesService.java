package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.system.IusUserRolesDO;
import com.xgit.iot.dao.mapper.system.IusUserRolesMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.IusUserRolesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IusUserRolesService extends BaseService<IusUserRolesVO,IusUserRolesDO>{

    @Autowired
    private IusUserRolesMapper iusUserRolesMapper;


    @Autowired
    private GenClient genClient;

    protected IusUserRolesService() {
        super(IusUserRolesVO.class, IusUserRolesDO.class);
    }


    /**
     * 查询
     * @param userId
     * @return
     */
    public IusUserRolesVO  select(String userId){
        IusUserRolesDO rolesDO = iusUserRolesMapper.select(userId);
        IusUserRolesVO result = new IusUserRolesVO();
        BeanUtils.copyProperties(rolesDO,result);
        return result;
    }


    /**
     * 批量逻辑删除
     * @param userIds
     * @return
     */
    @Transactional
    public int remove(List<String> userIds){
        int result = iusUserRolesMapper.remove(userIds);
        return result;
    }

    /**
     * 更新
     * @param model
     * @return
     */
    public int updateForUser(IusUserRolesDO model){
        int result = iusUserRolesMapper.updateForUser(model);
        return result;
    }


    /**
     * 新增
     * @param model
     * @return
     */
    public int add(IusUserRolesDO model){
        int result = iusUserRolesMapper.add(model);
        return result;
    }



}
