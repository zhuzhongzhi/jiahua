package com.xgit.iot.service.warn;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.craft.WagonOperateDO;
import com.xgit.iot.dao.entity.wagon.SilkWagonDO;
import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.entity.warn.ResidentAlarmDO;
import com.xgit.iot.dao.mapper.wagon.SilkWagonMapper;
import com.xgit.iot.dao.mapper.warn.LineAlarmMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import com.xgit.iot.service.vo.warn.ResidentAlarmVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineAlarmService extends BaseService<LineAlarmVO, LineAlarmDO>{

    @Autowired
    private LineAlarmMapper lineAlarmMapper;

    @Autowired
    private GenClient genClient;


    protected LineAlarmService() {
        super(LineAlarmVO.class, LineAlarmDO.class);
    }


    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<LineAlarmVO> page(SearchCommonVO<LineAlarmVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new LineAlarmVO());
        }
        LineAlarmDO infoDO = new LineAlarmDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<LineAlarmDO> doList = lineAlarmMapper.listCondition(infoDO);
        List<LineAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineAlarmDO -> {
            LineAlarmVO infoVO = new LineAlarmVO();
            BeanUtils.copyProperties(lineAlarmDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 查询今日告警
     * @return
     */
    public List<LineAlarmVO> listCurDate(){
        List<LineAlarmDO> doList = lineAlarmMapper.listCurDate();
        List<LineAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(residentAlarmDO -> {
            LineAlarmVO infoVO = new LineAlarmVO();
            BeanUtils.copyProperties(residentAlarmDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 新增线别告警
     * @param entity
     * @return
     */
    public Long addAlarm(LineAlarmVO entity){
        LineAlarmDO infoDO = new LineAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineAlarmMapper.addAlarm(infoDO);
        return infoDO.getAlarmId();
    }

    /**
     * 修改线别告警
     * @param entity
     * @return
     */
    public int modifyAlarm(LineAlarmVO entity){
        LineAlarmDO infoDO = new LineAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineAlarmMapper.modifyAlarm(infoDO);
        return result;
    }
}
