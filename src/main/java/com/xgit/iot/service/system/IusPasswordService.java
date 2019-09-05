package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.system.IusPasswordDO;
import com.xgit.iot.dao.mapper.system.IusPasswordMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.IusPasswordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IusPasswordService extends BaseService<IusPasswordVO,IusPasswordDO>{

    @Autowired
    private IusPasswordMapper iusPasswordMapper;

    @Autowired
    private GenClient genClient;


    protected IusPasswordService() {
        super(IusPasswordVO.class, IusPasswordDO.class);
    }

    /**
     * 批量逻辑删除
     * @param userIds
     * @return
     */
    @Transactional
    public int remove(List<String> userIds){
        int result = iusPasswordMapper.remove(userIds);
        return result;
    }

    /**
     * 更新
     * @param model
     * @return
     */
    public int updateForUser(IusPasswordDO model){
        int result = iusPasswordMapper.updateForUser(model);
        return result;
    }

    /**
     * 新增
     * @param model
     * @return
     */
    public int add(IusPasswordDO model){
        int result = iusPasswordMapper.add(model);
        return result;
    }
}
