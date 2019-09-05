package com.xgit.iot.service.craft;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.craft.WagonExceptionDO;
import com.xgit.iot.dao.entity.craft.WagonOperateDO;
import com.xgit.iot.dao.entity.system.IusAccountDO;
import com.xgit.iot.dao.mapper.craft.WagonExceptionMapper;
import com.xgit.iot.dao.mapper.craft.WagonOperateMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WagonExceptionService extends BaseService<WagonOperateVO, WagonOperateDO>{

    @Autowired
    private WagonExceptionMapper wagonExceptionMapper;

    @Autowired
    private GenClient genClient;


    protected WagonExceptionService() {
        super(WagonOperateVO.class, WagonOperateDO.class);
    }


    /**
     * 查询操作异常列表
     * @return
     */
    public List<WagonExceptionVO> listWagonOperate(Long opId){
        List<WagonExceptionDO> doList = wagonExceptionMapper.listAllExceptionByOpId(opId);

        List<WagonExceptionVO> voList = new ArrayList<>();
        voList = doList.stream().map(wagonExceptionDO -> {
            WagonExceptionVO infoVO = new WagonExceptionVO();
            BeanUtils.copyProperties(wagonExceptionDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 新增异常
     * @param entity
     * @return
     */
    public Long addException(WagonExceptionVO entity){
        WagonExceptionDO infoDO = new WagonExceptionDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = wagonExceptionMapper.addException(infoDO);
        return infoDO.getExId();
    }

    /**
     * 修改异常
     * @param entity
     * @return
     */
    public int modifyException(WagonExceptionVO entity){
        WagonExceptionDO infoDO = new WagonExceptionDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = wagonExceptionMapper.modifyException(infoDO);
        return result;
    }
}
