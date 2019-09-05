package com.xgit.iot.service.wagon;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.wagon.WagonSummaryDO;
import com.xgit.iot.dao.mapper.wagon.WagonSummaryMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.wagon.WagonSummaryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WagonSummaryService extends BaseService<WagonSummaryVO,WagonSummaryDO>{

    @Autowired
    private WagonSummaryMapper wagonSummaryMapper;

    @Autowired
    private GenClient genClient;


    protected WagonSummaryService() {
        super(WagonSummaryVO.class, WagonSummaryDO.class);
    }


    /**
     * 查询丝车概要信息
     * @return
     */
    public WagonSummaryVO summary(){
        WagonSummaryDO doInfo = wagonSummaryMapper.summary();
        WagonSummaryVO result = new WagonSummaryVO();
        BeanUtils.copyProperties(doInfo, result);
        return result;
    }
}
