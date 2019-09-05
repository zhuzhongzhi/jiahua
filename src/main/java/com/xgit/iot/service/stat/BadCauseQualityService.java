package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.BadCauseQualityDO;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.mapper.stat.BadCauseQualityMapper;
import com.xgit.iot.dao.mapper.stat.LevelQualityMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.BadCauseQualityVO;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BadCauseQualityService extends BaseService<BadCauseQualityVO, BadCauseQualityDO>{

    @Autowired
    private BadCauseQualityMapper badCauseQualityMapper;

    @Autowired
    private GenClient genClient;


    protected BadCauseQualityService() {
        super(BadCauseQualityVO.class, BadCauseQualityDO.class);
    }


    /**
     * 分页查询所有
     * @return
     */
    public PageCommonVO<BadCauseQualityVO> listPageDate(){
        PageCommonVO result = new PageCommonVO();
        List<BadCauseQualityDO> doList = badCauseQualityMapper.listAllDate();
        List<BadCauseQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            BadCauseQualityVO infoVO = new BadCauseQualityVO();
            BeanUtils.copyProperties(levelQualityDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<BadCauseQualityVO> listPageDate(SearchCommonVO<BadCauseQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new BadCauseQualityVO());
        }
        BadCauseQualityDO infoDO = new BadCauseQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<BadCauseQualityDO> doList = badCauseQualityMapper.listCondition(infoDO);
        List<BadCauseQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(badCauseQualityDO -> {
            BadCauseQualityVO infoVO = new BadCauseQualityVO();
            BeanUtils.copyProperties(badCauseQualityDO, infoVO);
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
    public List<BadCauseQualityVO> listAllDate(SearchCommonVO<BadCauseQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new BadCauseQualityVO());
        }
        BadCauseQualityDO infoDO = new BadCauseQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<BadCauseQualityDO> doList = badCauseQualityMapper.listCondition(infoDO);
        List<BadCauseQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(badCauseQualityDO -> {
            BadCauseQualityVO infoVO = new BadCauseQualityVO();
            BeanUtils.copyProperties(badCauseQualityDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增级别质量记录
     * @param entity
     * @return
     */
    public Long addCause(BadCauseQualityVO entity){
        BadCauseQualityDO infoDO = new BadCauseQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = badCauseQualityMapper.addCause(infoDO);
        return infoDO.getBcqId();
    }

    /**
     * 修改级别质量记录
     * @param entity
     * @return
     */
    public int modifyCause(BadCauseQualityVO entity){
        BadCauseQualityDO infoDO = new BadCauseQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = badCauseQualityMapper.modifyCause(infoDO);
        return result;
    }
}
