package com.xgit.iot.service.board;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.board.LineQualityBoardDO;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.mapper.board.LineQualityBoardMapper;
import com.xgit.iot.dao.mapper.stat.LevelQualityMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.board.LineQualityBoardVO;
import com.xgit.iot.service.vo.board.LineQualityThreeDaysVO;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineQualityBoardService extends BaseService<LineQualityBoardVO, LineQualityBoardDO>{

    @Autowired
    private LineQualityBoardMapper lineQualityBoardMapper;

    @Autowired
    private GenClient genClient;


    protected LineQualityBoardService() {
        super(LineQualityBoardVO.class, LineQualityBoardDO.class);
    }

    /**
     * 查询3日线别毛丝不良信息
     * @return
     */
    public LineQualityThreeDaysVO listLousiness(){
        /*List<LineQualityBoardDO> doList = lineQualityBoardMapper.listLousiness();
        List<LineQualityBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineQualityBoardDO -> {
            LineQualityBoardVO infoVO = new LineQualityBoardVO();
            BeanUtils.copyProperties(lineQualityBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());*/

        LineQualityThreeDaysVO result = new LineQualityThreeDaysVO();
        //先取今天最大的毛丝不良线别
        List<LineQualityBoardDO> doList1 = lineQualityBoardMapper.listLousiness1();
        LineQualityBoardDO do1 = doList1.get(0);
        LineQualityBoardVO infoVO1 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do1, infoVO1);
        result.setLineQualityBoardVOToday(infoVO1);

        //取前一天的最大毛丝不良线别
        List<LineQualityBoardDO> doList2 = lineQualityBoardMapper.listLousiness2();
        LineQualityBoardDO do2 = doList2.get(0);
        LineQualityBoardVO infoVO2 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do2, infoVO2);
        result.setLineQualityBoardVOYesterday(infoVO2);

        //取前二天的最大毛丝不良线别
        List<LineQualityBoardDO> doList3 = lineQualityBoardMapper.listLousiness3();
        LineQualityBoardDO do3 = doList3.get(0);

        LineQualityBoardVO infoVO3 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do3, infoVO3);
        result.setLineQualityBoardVOBeforeYesterday(infoVO3);

        return result;
    }

    /**
     * 查询3日线别染色不良信息
     * @return
     */
    public LineQualityThreeDaysVO listDye(){
        /*List<LineQualityBoardDO> doList = lineQualityBoardMapper.listDye();
        List<LineQualityBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineQualityBoardDO -> {
            LineQualityBoardVO infoVO = new LineQualityBoardVO();
            BeanUtils.copyProperties(lineQualityBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;*/

        LineQualityThreeDaysVO result = new LineQualityThreeDaysVO();
        //先取今天最大的毛丝不良线别
        List<LineQualityBoardDO> doList1 = lineQualityBoardMapper.listDye1();
        LineQualityBoardDO do1 = doList1.get(0);
        LineQualityBoardVO infoVO1 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do1, infoVO1);
        result.setLineQualityBoardVOToday(infoVO1);

        //取前一天的最大毛丝不良线别
        List<LineQualityBoardDO> doList2 = lineQualityBoardMapper.listDye2();
        LineQualityBoardDO do2 = doList2.get(0);
        LineQualityBoardVO infoVO2 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do2, infoVO2);
        result.setLineQualityBoardVOYesterday(infoVO2);

        //取前二天的最大毛丝不良线别
        List<LineQualityBoardDO> doList3 = lineQualityBoardMapper.listDye3();
        LineQualityBoardDO do3 = doList3.get(0);

        LineQualityBoardVO infoVO3 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do3, infoVO3);
        result.setLineQualityBoardVOBeforeYesterday(infoVO3);

        return result;
    }

    /**
     * 查询3日线别绕丝不良信息
     * @return
     */
    public LineQualityThreeDaysVO listWind(){
        /*List<LineQualityBoardDO> doList = lineQualityBoardMapper.listWind();
        List<LineQualityBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineQualityBoardDO -> {
            LineQualityBoardVO infoVO = new LineQualityBoardVO();
            BeanUtils.copyProperties(lineQualityBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;*/

        LineQualityThreeDaysVO result = new LineQualityThreeDaysVO();
        //先取今天最大的绕丝不良线别
        List<LineQualityBoardDO> doList1 = lineQualityBoardMapper.listWind1();
        LineQualityBoardDO do1 = doList1.get(0);
        LineQualityBoardVO infoVO1 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do1, infoVO1);
        result.setLineQualityBoardVOToday(infoVO1);

        //取前一天的最大绕丝不良线别
        List<LineQualityBoardDO> doList2 = lineQualityBoardMapper.listWind2();
        LineQualityBoardDO do2 = doList2.get(0);
        LineQualityBoardVO infoVO2 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do2, infoVO2);
        result.setLineQualityBoardVOYesterday(infoVO2);

        //取前二天的最大绕丝不良线别
        List<LineQualityBoardDO> doList3 = lineQualityBoardMapper.listWind3();
        LineQualityBoardDO do3 = doList3.get(0);

        LineQualityBoardVO infoVO3 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do3, infoVO3);
        result.setLineQualityBoardVOBeforeYesterday(infoVO3);

        return result;
    }

    /**
     * 查询3日线别飘丝不良信息
     * @return
     */
    public LineQualityThreeDaysVO listFloatSilk(){
        /*List<LineQualityBoardDO> doList = lineQualityBoardMapper.listFloatSilk();
        List<LineQualityBoardVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineQualityBoardDO -> {
            LineQualityBoardVO infoVO = new LineQualityBoardVO();
            BeanUtils.copyProperties(lineQualityBoardDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;*/

        LineQualityThreeDaysVO result = new LineQualityThreeDaysVO();
        //先取今天最大的飘丝不良线别
        List<LineQualityBoardDO> doList1 = lineQualityBoardMapper.listFloatSilk1();
        LineQualityBoardDO do1 = doList1.get(0);
        LineQualityBoardVO infoVO1 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do1, infoVO1);
        result.setLineQualityBoardVOToday(infoVO1);

        //取前一天的最大飘丝不良线别
        List<LineQualityBoardDO> doList2 = lineQualityBoardMapper.listFloatSilk2();
        LineQualityBoardDO do2 = doList2.get(0);
        LineQualityBoardVO infoVO2 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do2, infoVO2);
        result.setLineQualityBoardVOYesterday(infoVO2);

        //取前二天的最大飘丝不良线别
        List<LineQualityBoardDO> doList3 = lineQualityBoardMapper.listFloatSilk3();
        LineQualityBoardDO do3 = doList3.get(0);

        LineQualityBoardVO infoVO3 = new LineQualityBoardVO();
        BeanUtils.copyProperties(do3, infoVO3);
        result.setLineQualityBoardVOBeforeYesterday(infoVO3);

        return result;
    }


    /**
     * 新增级别不良记录
     * @param entity
     * @return
     */
    public Long addBoard(LineQualityBoardVO entity){
        LineQualityBoardDO infoDO = new LineQualityBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineQualityBoardMapper.addBoard(infoDO);
        return infoDO.getLqbId();
    }

    /**
     * 修改级别不良记录
     * @param entity
     * @return
     */
    public int modifyBoard(LineQualityBoardVO entity){
        LineQualityBoardDO infoDO = new LineQualityBoardDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineQualityBoardMapper.modifyBoard(infoDO);
        return result;
    }
}
