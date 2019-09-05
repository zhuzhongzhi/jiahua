package com.xgit.iot.dao.mapper.warn;

import com.xgit.iot.dao.entity.warn.AlarmHandleLogDO;
import com.xgit.iot.dao.entity.warn.SpinAlarmDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.warn.AlarmHandleLogVO;
import com.xgit.iot.service.vo.warn.SpinAlarmVO;
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
public interface AlarmHandleLogMapper extends BaseMapper<AlarmHandleLogVO, AlarmHandleLogDO> {
    List<AlarmHandleLogDO> listCurDate();
    List<AlarmHandleLogDO> listCondition(AlarmHandleLogDO entity);
    int addLog(AlarmHandleLogDO entity);
    int modifyLog(AlarmHandleLogDO entity);
}
