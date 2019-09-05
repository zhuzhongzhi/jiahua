package com.xgit.iot.dao.mapper.stat;

import com.xgit.iot.dao.entity.stat.DailyQualityReportDO;
import com.xgit.iot.dao.entity.stat.MonthlyQualityReportDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.stat.DailyQualityReportVO;
import com.xgit.iot.service.vo.stat.MonthlyQualityReportVO;
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
public interface MonthlyQualityReportMapper extends BaseMapper<MonthlyQualityReportVO, MonthlyQualityReportDO> {
    List<MonthlyQualityReportDO> listCurDate();
    List<MonthlyQualityReportDO> listCondition(MonthlyQualityReportDO entity);
    int addStat(MonthlyQualityReportDO entity);
    int modifyStat(MonthlyQualityReportDO entity);
}
