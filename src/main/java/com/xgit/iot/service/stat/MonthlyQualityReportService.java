package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.DailyQualityReportDO;
import com.xgit.iot.dao.entity.stat.MonthlyQualityReportDO;
import com.xgit.iot.dao.mapper.stat.DailyQualityReportMapper;
import com.xgit.iot.dao.mapper.stat.MonthlyQualityReportMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.DailyQualityReportVO;
import com.xgit.iot.service.vo.stat.MonthlyQualityReportVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonthlyQualityReportService extends BaseService<MonthlyQualityReportVO, MonthlyQualityReportDO>{

    @Autowired
    private MonthlyQualityReportMapper monthlyQualityReportMapper;

    @Autowired
    private GenClient genClient;


    protected MonthlyQualityReportService() {
        super(MonthlyQualityReportVO.class, MonthlyQualityReportDO.class);
    }


    /**
     * 查询今日
     * @return
     */
    public List<MonthlyQualityReportVO> listCurDate(){
        List<MonthlyQualityReportDO> doList = monthlyQualityReportMapper.listCurDate();
        List<MonthlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(monthlyQualityReportDO -> {
            MonthlyQualityReportVO infoVO = new MonthlyQualityReportVO();
            BeanUtils.copyProperties(monthlyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<MonthlyQualityReportVO> listPageDate(SearchCommonVO<MonthlyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new MonthlyQualityReportVO());
        }
        MonthlyQualityReportDO infoDO = new MonthlyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<MonthlyQualityReportDO> doList = monthlyQualityReportMapper.listCondition(infoDO);
        List<MonthlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(monthlyQualityReportDO -> {
            MonthlyQualityReportVO infoVO = new MonthlyQualityReportVO();
            BeanUtils.copyProperties(monthlyQualityReportDO, infoVO);
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
    public List<MonthlyQualityReportVO> listAllDate(SearchCommonVO<MonthlyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new MonthlyQualityReportVO());
        }
        MonthlyQualityReportDO infoDO = new MonthlyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<MonthlyQualityReportDO> doList = monthlyQualityReportMapper.listCondition(infoDO);
        List<MonthlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(monthlyQualityReportDO -> {
            MonthlyQualityReportVO infoVO = new MonthlyQualityReportVO();
            BeanUtils.copyProperties(monthlyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增产量记录
     * @param entity
     * @return
     */
    public Long addStat(MonthlyQualityReportVO entity){
        MonthlyQualityReportDO infoDO = new MonthlyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = monthlyQualityReportMapper.addStat(infoDO);
        return infoDO.getQrId();
    }

    /**
     * 修改产量记录
     * @param entity
     * @return
     */
    public int modifyStat(MonthlyQualityReportVO entity){
        MonthlyQualityReportDO infoDO = new MonthlyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = monthlyQualityReportMapper.modifyStat(infoDO);
        return result;
    }
}
