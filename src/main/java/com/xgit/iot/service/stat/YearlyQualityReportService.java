package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.MonthlyQualityReportDO;
import com.xgit.iot.dao.entity.stat.YearlyQualityReportDO;
import com.xgit.iot.dao.mapper.stat.MonthlyQualityReportMapper;
import com.xgit.iot.dao.mapper.stat.YearlyQualityReportMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.MonthlyQualityReportVO;
import com.xgit.iot.service.vo.stat.YearlyQualityReportVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YearlyQualityReportService extends BaseService<YearlyQualityReportVO, YearlyQualityReportDO>{

    @Autowired
    private YearlyQualityReportMapper yearlyQualityReportMapper;

    @Autowired
    private GenClient genClient;


    protected YearlyQualityReportService() {
        super(YearlyQualityReportVO.class, YearlyQualityReportDO.class);
    }


    /**
     * 查询今日
     * @return
     */
    public List<YearlyQualityReportVO> listCurDate(){
        List<YearlyQualityReportDO> doList = yearlyQualityReportMapper.listCurDate();
        List<YearlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(yearlyQualityReportDO -> {
            YearlyQualityReportVO infoVO = new YearlyQualityReportVO();
            BeanUtils.copyProperties(yearlyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<YearlyQualityReportVO> listPageDate(SearchCommonVO<YearlyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new YearlyQualityReportVO());
        }
        YearlyQualityReportDO infoDO = new YearlyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<YearlyQualityReportDO> doList = yearlyQualityReportMapper.listCondition(infoDO);
        List<YearlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(yearlyQualityReportDO -> {
            YearlyQualityReportVO infoVO = new YearlyQualityReportVO();
            BeanUtils.copyProperties(yearlyQualityReportDO, infoVO);
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
    public List<YearlyQualityReportVO> listAllDate(SearchCommonVO<YearlyQualityReportVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new YearlyQualityReportVO());
        }
        YearlyQualityReportDO infoDO = new YearlyQualityReportDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<YearlyQualityReportDO> doList = yearlyQualityReportMapper.listCondition(infoDO);
        List<YearlyQualityReportVO> voList = new ArrayList<>();
        voList = doList.stream().map(yearlyQualityReportDO -> {
            YearlyQualityReportVO infoVO = new YearlyQualityReportVO();
            BeanUtils.copyProperties(yearlyQualityReportDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增产量记录
     * @param entity
     * @return
     */
    public Long addStat(YearlyQualityReportVO entity){
        YearlyQualityReportDO infoDO = new YearlyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = yearlyQualityReportMapper.addStat(infoDO);
        return infoDO.getQrId();
    }

    /**
     * 修改产量记录
     * @param entity
     * @return
     */
    public int modifyStat(YearlyQualityReportVO entity){
        YearlyQualityReportDO infoDO = new YearlyQualityReportDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = yearlyQualityReportMapper.modifyStat(infoDO);
        return result;
    }
}
