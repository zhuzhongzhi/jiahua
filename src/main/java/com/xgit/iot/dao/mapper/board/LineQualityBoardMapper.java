package com.xgit.iot.dao.mapper.board;

import com.xgit.iot.dao.entity.board.LineQualityBoardDO;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.board.LineQualityBoardVO;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 账号信息表 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface LineQualityBoardMapper extends BaseMapper<LineQualityBoardVO, LineQualityBoardDO> {
    List<LineQualityBoardDO> listLousiness();
    List<LineQualityBoardDO> listLousiness1();
    List<LineQualityBoardDO> listLousiness2();
    List<LineQualityBoardDO> listLousiness3();
    List<LineQualityBoardDO> listDye();
    List<LineQualityBoardDO> listDye1();
    List<LineQualityBoardDO> listDye2();
    List<LineQualityBoardDO> listDye3();
    List<LineQualityBoardDO> listWind();
    List<LineQualityBoardDO> listWind1();
    List<LineQualityBoardDO> listWind2();
    List<LineQualityBoardDO> listWind3();
    List<LineQualityBoardDO> listFloatSilk();
    List<LineQualityBoardDO> listFloatSilk1();
    List<LineQualityBoardDO> listFloatSilk2();
    List<LineQualityBoardDO> listFloatSilk3();
    int addBoard(LineQualityBoardDO entity);
    int modifyBoard(LineQualityBoardDO entity);
}
