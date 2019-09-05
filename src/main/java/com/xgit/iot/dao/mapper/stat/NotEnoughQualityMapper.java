package com.xgit.iot.dao.mapper.stat;

import com.xgit.iot.dao.entity.stat.NotEnoughQualityDO;
import com.xgit.iot.dao.entity.stat.OutputStatDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.stat.NotEnoughQualityVO;
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
public interface NotEnoughQualityMapper extends BaseMapper<NotEnoughQualityVO, NotEnoughQualityDO> {
    List<NotEnoughQualityDO> listAllDate();
    List<NotEnoughQualityDO> listCondition(NotEnoughQualityDO entity);
    int addQuality(NotEnoughQualityDO entity);
    int modifyQuality(NotEnoughQualityDO entity);
}
