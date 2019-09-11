package com.xgit.iot.dao.mapper.warn;

import com.xgit.iot.dao.entity.craft.WagonOperateDO;
import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

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
public interface LineAlarmMapper extends BaseMapper<LineAlarmVO, LineAlarmDO> {
    LineAlarmDO getById(@Param("alarmId") Long alarmId);
    List<LineAlarmDO> listCurDate();
    List<LineAlarmDO> listCondition(LineAlarmDO entity);
    int addAlarm(LineAlarmDO entity);
    int modifyAlarm(LineAlarmDO entity);
}
