package com.xgit.iot.dao.mapper.stat;

import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.entity.stat.OutputStatDO;
import com.xgit.iot.dao.entity.warn.AlarmHandleLogDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import com.xgit.iot.service.vo.stat.OutputStatVO;
import com.xgit.iot.service.vo.warn.AlarmHandleLogVO;
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
public interface LevelQualityMapper extends BaseMapper<LevelQualityVO, LevelQualityDO> {
    List<LevelQualityDO> listAllDate();
    List<LevelQualityDO> listCondition(LevelQualityDO entity);
    int addLevel(LevelQualityDO entity);
    int modifyLevel(LevelQualityDO entity);
}
