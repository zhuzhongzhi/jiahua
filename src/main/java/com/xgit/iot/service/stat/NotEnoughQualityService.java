package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.entity.stat.NotEnoughQualityDO;
import com.xgit.iot.dao.mapper.stat.LevelQualityMapper;
import com.xgit.iot.dao.mapper.stat.NotEnoughQualityMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import com.xgit.iot.service.vo.stat.NotEnoughQualityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotEnoughQualityService extends BaseService<NotEnoughQualityVO, NotEnoughQualityDO>{

    @Autowired
    private NotEnoughQualityMapper notEnoughQualityMapper;

    @Autowired
    private GenClient genClient;


    protected NotEnoughQualityService() {
        super(NotEnoughQualityVO.class, NotEnoughQualityDO.class);
    }


    /**
     * 分页查询所有
     * @return
     */
    public PageCommonVO<NotEnoughQualityVO> listPageDate(){
        PageCommonVO result = new PageCommonVO();
        List<NotEnoughQualityDO> doList = notEnoughQualityMapper.listAllDate();
        List<NotEnoughQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            NotEnoughQualityVO infoVO = new NotEnoughQualityVO();
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
    public PageCommonVO<NotEnoughQualityVO> listPageDate(SearchCommonVO<NotEnoughQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new NotEnoughQualityVO());
        }
        NotEnoughQualityDO infoDO = new NotEnoughQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<NotEnoughQualityDO> doList = notEnoughQualityMapper.listCondition(infoDO);
        List<NotEnoughQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(notEnoughQualityDO -> {
            NotEnoughQualityVO infoVO = new NotEnoughQualityVO();
            BeanUtils.copyProperties(notEnoughQualityDO, infoVO);
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
    public List<NotEnoughQualityVO> listAllDate(SearchCommonVO<NotEnoughQualityVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new NotEnoughQualityVO());
        }
        NotEnoughQualityDO infoDO = new NotEnoughQualityDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<NotEnoughQualityDO> doList = notEnoughQualityMapper.listCondition(infoDO);
        List<NotEnoughQualityVO> voList = new ArrayList<>();
        voList = doList.stream().map(levelQualityDO -> {
            NotEnoughQualityVO infoVO = new NotEnoughQualityVO();
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
    public Long addQuality(NotEnoughQualityVO entity){
        NotEnoughQualityDO infoDO = new NotEnoughQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = notEnoughQualityMapper.addQuality(infoDO);
        return infoDO.getNeqId();
    }

    /**
     * 修改级别质量记录
     * @param entity
     * @return
     */
    public int modifyQuality(NotEnoughQualityVO entity){
        NotEnoughQualityDO infoDO = new NotEnoughQualityDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = notEnoughQualityMapper.modifyQuality(infoDO);
        return result;
    }
}
