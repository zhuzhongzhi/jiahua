package com.xgit.iot.service.wagon;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.wagon.WagonPosDO;
import com.xgit.iot.dao.mapper.wagon.WagonPosMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WagonPosService extends BaseService<WagonPosVO,WagonPosDO>{

    @Autowired
    private WagonPosMapper wagonPosMapper;

    @Autowired
    private GenClient genClient;


    protected WagonPosService() {
        super(WagonPosVO.class, WagonPosDO.class);
    }


    /**
     * 查询丝车最新位置信息
     * @return
     */
    public WagonPosVO wagonPos(String code){
        WagonPosDO doInfo = wagonPosMapper.wagonPos(code);
        WagonPosVO result = new WagonPosVO();
        BeanUtils.copyProperties(doInfo, result);
        return result;
    }

    /**
     * 查询丝车所有位置信息
     * @return
     */
    public List<WagonPosVO> listWagonPos(String code){
        List<WagonPosDO> doList = wagonPosMapper.listWagonPos(code);
        List<WagonPosVO> voList = new ArrayList<>();
        voList = doList.stream().map(wagonPosVO -> {
            WagonPosVO infoVO = new WagonPosVO();
            BeanUtils.copyProperties(wagonPosVO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }
}
