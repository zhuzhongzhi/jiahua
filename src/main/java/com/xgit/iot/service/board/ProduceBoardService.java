package com.xgit.iot.service.board;

import com.bkrwin.ufast.feign.GenClient;
import com.xgit.iot.dao.entity.board.CauseBoardDO;
import com.xgit.iot.dao.entity.board.ProduceBoardDO;
import com.xgit.iot.dao.mapper.board.CauseBoardMapper;
import com.xgit.iot.dao.mapper.board.ProduceBoardMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.board.CauseBoardVO;
import com.xgit.iot.service.vo.board.ProduceBoardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduceBoardService extends BaseService<ProduceBoardVO, ProduceBoardDO>{

    @Autowired
    private ProduceBoardMapper produceBoardMapper;

    @Autowired
    private GenClient genClient;


    protected ProduceBoardService() {
        super(ProduceBoardVO.class, ProduceBoardDO.class);
    }

    /**
     * 查询当日产量信息
     * @return
     */
    public List<ProduceBoardVO> listCurDate(){
        List<ProduceBoardDO> doList = produceBoardMapper.listCurDate();
        List<ProduceBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(produceBoardDO -> {
            ProduceBoardVO infoVO = new ProduceBoardVO();
            BeanUtils.copyProperties(produceBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 查询历史(12天内)产量信息
     * @return
     */
    public List<ProduceBoardVO> listRecent(){
        List<ProduceBoardDO> doList = produceBoardMapper.listRecent();
        List<ProduceBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(produceBoardDO -> {
            ProduceBoardVO infoVO = new ProduceBoardVO();
            BeanUtils.copyProperties(produceBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }


    /**
     * 新增产量记录
     * @param entity
     * @return
     */
    public Long addBoard(ProduceBoardVO entity){
        ProduceBoardDO infoDO = new ProduceBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = produceBoardMapper.addBoard(infoDO);
        return infoDO.getPbId();
    }

    /**
     * 修改产量记录
     * @param entity
     * @return
     */
    public int modifyBoard(ProduceBoardVO entity){
        ProduceBoardDO infoDO = new ProduceBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = produceBoardMapper.modifyBoard(infoDO);
        return result;
    }
}
