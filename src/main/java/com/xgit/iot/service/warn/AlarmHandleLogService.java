package com.xgit.iot.service.warn;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.warn.AlarmHandleLogDO;
import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.mapper.warn.AlarmHandleLogMapper;
import com.xgit.iot.dao.mapper.warn.LineAlarmMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.warn.AlarmHandleLogVO;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlarmHandleLogService extends BaseService<AlarmHandleLogVO, AlarmHandleLogDO>{

    @Autowired
    private AlarmHandleLogMapper alarmHandleLogMapper;

    @Autowired
    private GenClient genClient;


    protected AlarmHandleLogService() {
        super(AlarmHandleLogVO.class, AlarmHandleLogDO.class);
    }


    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<AlarmHandleLogVO> page(SearchCommonVO<AlarmHandleLogVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new AlarmHandleLogVO());
        }
        AlarmHandleLogDO infoDO = new AlarmHandleLogDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<AlarmHandleLogDO> doList = alarmHandleLogMapper.listCondition(infoDO);
        List<AlarmHandleLogVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineAlarmDO -> {
            AlarmHandleLogVO infoVO = new AlarmHandleLogVO();
            BeanUtils.copyProperties(lineAlarmDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 新增线别告警
     * @param entity
     * @return
     */
    public Long addAlarm(AlarmHandleLogVO entity){
        AlarmHandleLogDO infoDO = new AlarmHandleLogDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = alarmHandleLogMapper.addLog(infoDO);
        return infoDO.getAlarmId();
    }

    /**
     * 修改线别告警
     * @param entity
     * @return
     */
    public int modifyAlarm(AlarmHandleLogVO entity){
        AlarmHandleLogDO infoDO = new AlarmHandleLogDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = alarmHandleLogMapper.modifyLog(infoDO);
        return result;
    }
}
