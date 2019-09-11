package com.xgit.iot.dao.mapper.warn;

import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.entity.warn.ResidentAlarmDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import com.xgit.iot.service.vo.warn.ResidentAlarmVO;
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
public interface ResidentAlarmMapper extends BaseMapper<ResidentAlarmVO, ResidentAlarmDO> {
    ResidentAlarmDO getById(@Param("alarmId") Long alarmId);
    List<ResidentAlarmDO> listCurDate();
    List<ResidentAlarmDO> listCondition(ResidentAlarmDO entity);
    int addAlarm(ResidentAlarmDO entity);
    int modifyAlarm(ResidentAlarmDO entity);
}
