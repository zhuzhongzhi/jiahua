package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.system.IusAccountDO;
import com.xgit.iot.dao.mapper.system.IusAccountMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.IusAccountVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IusAccountService extends BaseService<IusAccountVO,IusAccountDO>{

    @Autowired
    private IusAccountMapper iusAccountMapper;

    @Autowired
    private GenClient genClient;


    protected IusAccountService() {
        super(IusAccountVO.class, IusAccountDO.class);
    }


    /**
     * 查询
     * @param userId
     * @return
     */
    public IusAccountVO  select(String userId){
        IusAccountDO accountDO = iusAccountMapper.select(userId);
        IusAccountVO result = new IusAccountVO();
        BeanUtils.copyProperties(accountDO,result);
        return result;
    }

    /**
     * 批量逻辑删除
     * @param userIds
     * @return
     */
    @Transactional
    public int remove(List<String> userIds){
        int result = iusAccountMapper.remove(userIds);
        return result;
    }


    /**
     * 更新
     * @param model
     * @return
     */
    public int updateForUser(IusAccountDO model){
        int result = iusAccountMapper.updateForUser(model);
        return result;
    }

    /**
     * 新增
     * @param model
     * @return
     */
    public int add(IusAccountDO model){
        int result = iusAccountMapper.add(model);
        return result;
    }
}
