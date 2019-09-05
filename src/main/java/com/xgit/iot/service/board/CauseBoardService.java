package com.xgit.iot.service.board;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.board.CauseBoardDO;
import com.xgit.iot.dao.entity.board.LineQualityBoardDO;
import com.xgit.iot.dao.mapper.board.CauseBoardMapper;
import com.xgit.iot.dao.mapper.board.LineQualityBoardMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.board.CauseBoardVO;
import com.xgit.iot.service.vo.board.LineQualityBoardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CauseBoardService extends BaseService<CauseBoardVO, CauseBoardDO>{

    @Autowired
    private CauseBoardMapper causeBoardMapper;

    @Autowired
    private GenClient genClient;


    protected CauseBoardService() {
        super(CauseBoardVO.class, CauseBoardDO.class);
    }

    /**
     * 查询当日不良因素次数
     * @return
     */
    public List<CauseBoardVO> listCurDate(){
        List<CauseBoardDO> doList = causeBoardMapper.listCurDate();
        List<CauseBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(causeBoardDO -> {
            CauseBoardVO infoVO = new CauseBoardVO();
            BeanUtils.copyProperties(causeBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }


    /**
     * 新增不良因素次数记录
     * @param entity
     * @return
     */
    public Long addBoard(CauseBoardVO entity){
        CauseBoardDO infoDO = new CauseBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = causeBoardMapper.addBoard(infoDO);
        return infoDO.getCbId();
    }

    /**
     * 修改不良因素次数记录
     * @param entity
     * @return
     */
    public int modifyBoard(CauseBoardVO entity){
        CauseBoardDO infoDO = new CauseBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = causeBoardMapper.modifyBoard(infoDO);
        return result;
    }
}
