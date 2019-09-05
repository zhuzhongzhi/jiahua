package com.xgit.iot.dao.mapper.stat;

import com.xgit.iot.dao.entity.stat.BadCauseQualityDO;
import com.xgit.iot.dao.entity.stat.OutputStatDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.stat.BadCauseQualityVO;
import com.xgit.iot.service.vo.stat.OutputStatVO;
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
public interface BadCauseQualityMapper extends BaseMapper<BadCauseQualityVO, BadCauseQualityDO> {
    List<BadCauseQualityDO> listAllDate();
    List<BadCauseQualityDO> listCondition(BadCauseQualityDO entity);
    int addCause(BadCauseQualityDO entity);
    int modifyCause(BadCauseQualityDO entity);
}
