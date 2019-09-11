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
import com.xgit.iot.dao.mapper.warn.SpinAlarmMapper;
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
public class SpinAlarmService extends BaseService<SpinAlarmVO, SpinAlarmDO>{

    @Autowired
    private SpinAlarmMapper spinAlarmMapper;

    @Autowired
    private GenClient genClient;


    protected SpinAlarmService() {
        super(SpinAlarmVO.class, SpinAlarmDO.class);
    }


    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<SpinAlarmVO> page(SearchCommonVO<SpinAlarmVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new SpinAlarmVO());
        }
        SpinAlarmDO infoDO = new SpinAlarmDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<SpinAlarmDO> doList = spinAlarmMapper.listCondition(infoDO);
        List<SpinAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineAlarmDO -> {
            SpinAlarmVO infoVO = new SpinAlarmVO();
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
    public List<SpinAlarmVO> listCurDate(){
        List<SpinAlarmDO> doList = spinAlarmMapper.listCurDate();
        List<SpinAlarmVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineAlarmDO -> {
            SpinAlarmVO infoVO = new SpinAlarmVO();
            BeanUtils.copyProperties(lineAlarmDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 新增锭位质量告警
     * @param entity
     * @return
     */
    public Long addAlarm(SpinAlarmVO entity){
        SpinAlarmDO infoDO = new SpinAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = spinAlarmMapper.addAlarm(infoDO);
        return infoDO.getAlarmId();
    }

    /**
     * 修改锭位质量告警
     * @param entity
     * @return
     */
    public int modifyAlarm(SpinAlarmVO entity){
        SpinAlarmDO infoDO = new SpinAlarmDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = spinAlarmMapper.modifyAlarm(infoDO);
        return result;
    }

    /**
     * 根据id查询
     * @param alarmId
     * @return
     */
    public SpinAlarmVO getById(Long alarmId){
        SpinAlarmDO spinAlarmDO =  spinAlarmMapper.getById(alarmId);
        SpinAlarmVO infoVO = new SpinAlarmVO();
        BeanUtils.copyProperties(spinAlarmDO, infoVO);
        return infoVO;
    }
}
