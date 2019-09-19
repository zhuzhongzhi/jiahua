package com.xgit.iot.service.stat;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.stat.LevelQualityDO;
import com.xgit.iot.dao.entity.stat.OutputStatDO;
import com.xgit.iot.dao.mapper.stat.LevelQualityMapper;
import com.xgit.iot.dao.mapper.stat.OutputStatMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.stat.LevelQualityVO;
import com.xgit.iot.service.vo.stat.OutputStatVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OutputStatService extends BaseService<OutputStatVO, OutputStatDO>{

    @Autowired
    private OutputStatMapper outputStatMapper;

    @Autowired
    private GenClient genClient;


    protected OutputStatService() {
        super(OutputStatVO.class, OutputStatDO.class);
    }


    /**
     * 查询今日
     * @return
     */
    public List<OutputStatVO> listCurDate(){
        List<OutputStatDO> doList = outputStatMapper.listCurDate();
        List<OutputStatVO> voList = new ArrayList<>();
        voList = doList.stream().map(outputStatDO -> {
            OutputStatVO infoVO = new OutputStatVO();
            BeanUtils.copyProperties(outputStatDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<OutputStatVO> listPageDate(SearchCommonVO<OutputStatVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new OutputStatVO());
        }
        OutputStatDO infoDO = new OutputStatDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<OutputStatDO> doList = outputStatMapper.listCondition(infoDO);
        List<OutputStatVO> voList = new ArrayList<>();
        voList = doList.stream().map(outputStatDO -> {
            OutputStatVO infoVO = new OutputStatVO();
            BeanUtils.copyProperties(outputStatDO, infoVO);
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
    public List<OutputStatVO> listAllDate(SearchCommonVO<OutputStatVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(1, 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new OutputStatVO());
        }
        OutputStatDO infoDO = new OutputStatDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<OutputStatDO> doList = outputStatMapper.listCondition(infoDO);
        List<OutputStatVO> voList = new ArrayList<>();
        voList = doList.stream().map(outputStatDO -> {
            OutputStatVO infoVO = new OutputStatVO();
            BeanUtils.copyProperties(outputStatDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 新增产量记录
     * @param entity
     * @return
     */
    public Long addStat(OutputStatVO entity){
        OutputStatDO infoDO = new OutputStatDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = outputStatMapper.addStat(infoDO);
        return infoDO.getOsId();
    }

    /**
     * 修改产量记录
     * @param entity
     * @return
     */
    public int modifyStat(OutputStatVO entity){
        OutputStatDO infoDO = new OutputStatDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = outputStatMapper.modifyStat(infoDO);
        return result;
    }
}
