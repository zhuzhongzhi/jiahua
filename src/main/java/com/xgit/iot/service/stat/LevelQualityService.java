package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.entity.warn.LineAlarmDO;
import com.xgit.iot.dao.mapper.stat.LevelQualityMapper;
import com.xgit.iot.dao.mapper.warn.LineAlarmMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import com.xgit.iot.service.vo.warn.LineAlarmVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelQualityService extends BaseService<LevelQualityVO, LevelQualityDO>{

    @Autowired
    private LevelQualityMapper levelQualityMapper;

    @Autowired
    private GenClient genClient;


    protected LevelQualityService() {
        super(LevelQualityVO.class, LevelQualityDO.class);
    }


    /**
     * 分页查询所有
     * @return
     */
    public PageCommonVO<LevelQualityVO> listPageDate(){
        PageCommonVO result = new PageCommonVO();
        List<LevelQualityDO> doList = levelQualityMapper.listAllDate();
        List<LevelQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            LevelQualityVO infoVO = new LevelQualityVO();
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
    public PageCommonVO<LevelQualityVO> listPageDate(SearchCommonVO<LevelQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new LevelQualityVO());
        }
        LevelQualityDO infoDO = new LevelQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<LevelQualityDO> doList = levelQualityMapper.listCondition(infoDO);
        List<LevelQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            LevelQualityVO infoVO = new LevelQualityVO();
            BeanUtils.copyProperties(levelQualityDO, infoVO);
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
    public List<LevelQualityVO> listAllDate(SearchCommonVO<LevelQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new LevelQualityVO());
        }
        LevelQualityDO infoDO = new LevelQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<LevelQualityDO> doList = levelQualityMapper.listCondition(infoDO);
        List<LevelQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            LevelQualityVO infoVO = new LevelQualityVO();
            BeanUtils.copyProperties(levelQualityDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增级别质量记录
     * @param entity
     * @return
     */
    public Long addLevel(LevelQualityVO entity){
        LevelQualityDO infoDO = new LevelQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = levelQualityMapper.addLevel(infoDO);
        return infoDO.getLqId();
    }

    /**
     * 修改级别质量记录
     * @param entity
     * @return
     */
    public int modifyLevel(LevelQualityVO entity){
        LevelQualityDO infoDO = new LevelQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = levelQualityMapper.modifyLevel(infoDO);
        return result;
    }
}
