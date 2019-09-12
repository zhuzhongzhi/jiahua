package com.xgit.iot.dao.mapper.board;

import com.xgit.iot.dao.entity.board.CauseBoardDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.board.CauseBoardVO;
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
public interface CauseBoardMapper extends BaseMapper<CauseBoardVO, CauseBoardDO> {
    List<CauseBoardDO> listCurDate();
    int addBoard(CauseBoardDO entity);
    int modifyBoard(CauseBoardDO entity);
}
