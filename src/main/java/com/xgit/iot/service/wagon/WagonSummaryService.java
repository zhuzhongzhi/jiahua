package com.xgit.iot.service.wagon;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.wagon.WagonSummaryDO;
import com.xgit.iot.dao.mapper.wagon.WagonSummaryMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import com.xgit.iot.service.vo.wagon.WagonSummaryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    public List<WagonSummaryVO> summary(){
        List<WagonSummaryDO> doList = wagonSummaryMapper.summary();
        List<WagonSummaryVO> voList = new ArrayList<>();
        voList = doList.stream().map(wagonSummaryDO -> {
            WagonSummaryVO infoVO = new WagonSummaryVO();
            BeanUtils.copyProperties(wagonSummaryDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }
}
