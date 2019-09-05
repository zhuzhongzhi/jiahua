package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.DailyQualityReportDO;
import com.xgit.iot.dao.entity.stat.OutputStatDO;
import com.xgit.iot.dao.mapper.stat.DailyQualityReportMapper;
import com.xgit.iot.dao.mapper.stat.OutputStatMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.DailyQualityReportVO;
import com.xgit.iot.service.vo.stat.OutputStatVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyQualityReportService extends BaseService<DailyQualityReportVO, DailyQualityReportDO>{

    @Autowired
    private DailyQualityReportMapper dailyQualityReportMapper;

    @Autowired
    private GenClient genClient;


    protected DailyQualityReportService() {
        super(DailyQualityReportVO.class, DailyQualityReportDO.class);
    }


    /**
     * 查询今日
     * @return
     */
    public List<DailyQualityReportVO> listCurDate(){
        List<DailyQualityReportDO> doList = dailyQualityReportMapper.listCurDate();
        List<DailyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(dailyQualityReportDO -> {
            DailyQualityReportVO infoVO = new DailyQualityReportVO();
            BeanUtils.copyProperties(dailyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<DailyQualityReportVO> listPageDate(SearchCommonVO<DailyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new DailyQualityReportVO());
        }
        DailyQualityReportDO infoDO = new DailyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<DailyQualityReportDO> doList = dailyQualityReportMapper.listCondition(infoDO);
        List<DailyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(dailyQualityReportDO -> {
            DailyQualityReportVO infoVO = new DailyQualityReportVO();
            BeanUtils.copyProperties(dailyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 条件查询所有
     * @param condition
     * @return
     */
    public List<DailyQualityReportVO> listAllDate(SearchCommonVO<DailyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new DailyQualityReportVO());
        }
        DailyQualityReportDO infoDO = new DailyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<DailyQualityReportDO> doList = dailyQualityReportMapper.listCondition(infoDO);
        List<DailyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(dailyQualityReportDO -> {
            DailyQualityReportVO infoVO = new DailyQualityReportVO();
            BeanUtils.copyProperties(dailyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增产量记录
     * @param entity
     * @return
     */
    public Long addStat(DailyQualityReportVO entity){
        DailyQualityReportDO infoDO = new DailyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = dailyQualityReportMapper.addStat(infoDO);
        return infoDO.getQrId();
    }

    /**
     * 修改产量记录
     * @param entity
     * @return
     */
    public int modifyStat(DailyQualityReportVO entity){
        DailyQualityReportDO infoDO = new DailyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = dailyQualityReportMapper.modifyStat(infoDO);
        return result;
    }
}
