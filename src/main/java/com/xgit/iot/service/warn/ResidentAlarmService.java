package com.xgit.iot.service.warn;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.entity.warn.ResidentAlarmDO;
import com.xgit.iot.dao.entity.warn.SpinAlarmDO;
import com.xgit.iot.dao.mapper.warn.LineAlarmMapper;
import com.xgit.iot.dao.mapper.warn.ResidentAlarmMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import com.xgit.iot.service.vo.warn.ResidentAlarmVO;
import com.xgit.iot.service.vo.warn.SpinAlarmVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentAlarmService extends BaseService<ResidentAlarmVO, ResidentAlarmDO>{

    @Autowired
    private ResidentAlarmMapper residentAlarmMapper;

    @Autowired
    private GenClient genClient;


    protected ResidentAlarmService() {
        super(ResidentAlarmVO.class, ResidentAlarmDO.class);
    }


    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<ResidentAlarmVO> page(SearchCommonVO<ResidentAlarmVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new ResidentAlarmVO());
        }
        ResidentAlarmDO infoDO = new ResidentAlarmDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<ResidentAlarmDO> doList = residentAlarmMapper.listCondition(infoDO);
        List<ResidentAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineAlarmDO -> {
            ResidentAlarmVO infoVO = new ResidentAlarmVO();
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
    public List<ResidentAlarmVO> listCurDate(){
        List<ResidentAlarmDO> doList = residentAlarmMapper.listCurDate();
        List<ResidentAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(residentAlarmDO -> {
            ResidentAlarmVO infoVO = new ResidentAlarmVO();
            BeanUtils.copyProperties(residentAlarmDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 新增驻留告警
     * @param entity
     * @return
     */
    public Long addAlarm(ResidentAlarmVO entity){
        ResidentAlarmDO infoDO = new ResidentAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = residentAlarmMapper.addAlarm(infoDO);
        return infoDO.getAlarmId();
    }

    /**
     * 修改驻留告警
     * @param entity
     * @return
     */
    public int modifyAlarm(ResidentAlarmVO entity){
        ResidentAlarmDO infoDO = new ResidentAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = residentAlarmMapper.modifyAlarm(infoDO);
        return result;
    }

    /**
     * 根据id查询
     * @param alarmId
     * @return
     */
    public ResidentAlarmVO getById(Long alarmId){
        ResidentAlarmDO residentAlarmDO =  residentAlarmMapper.getById(alarmId);
        ResidentAlarmVO infoVO = new ResidentAlarmVO();
        BeanUtils.copyProperties(residentAlarmDO, infoVO);
        return infoVO;
    }
}
