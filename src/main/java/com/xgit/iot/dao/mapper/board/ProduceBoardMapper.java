package com.xgit.iot.dao.mapper.board;

import com.xgit.iot.dao.entity.board.CauseBoardDO;
import com.xgit.iot.dao.entity.board.ProduceBoardDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.board.CauseBoardVO;
import com.xgit.iot.service.vo.board.ProduceBoardVO;
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
public interface ProduceBoardMapper extends BaseMapper<ProduceBoardVO, ProduceBoardDO> {
    List<ProduceBoardDO> listCurDate();
    List<ProduceBoardDO> listRecent();
    List<ProduceBoardDO> listCondition(ProduceBoardDO entity);
    List<ProduceBoardDO> listRecentCondition(ProduceBoardDO entity);
    int addBoard(ProduceBoardDO entity);
    int modifyBoard(ProduceBoardDO entity);
}
