package com.xgit.iot.service.wagon;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.wagon.SilkWagonDO;
import com.xgit.iot.dao.mapper.wagon.SilkWagonMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SilkWagonService extends BaseService<SilkWagonVO,SilkWagonDO>{

    @Autowired
    private SilkWagonMapper silkWagonMapper;

    @Autowired
    private GenClient genClient;


    protected SilkWagonService() {
        super(SilkWagonVO.class, SilkWagonDO.class);
    }

    /**
     * 根据swId查询丝车信息
     * @param swId
     * @return
     */
    public SilkWagonDO getById(Long swId){
        return silkWagonMapper.getById(swId);
    }

    /**
     * 新增丝车信息
     * @param entity
     * @return
     */
    public Long addWagon(SilkWagonVO entity){
        SilkWagonDO infoDO = new SilkWagonDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = silkWagonMapper.addWagon(infoDO);

        return infoDO.getSwId();
    }

    /**
     * 修改丝车信息
     * @param entity
     * @return
     */
    public Integer modifyWagon(SilkWagonVO entity){
        SilkWagonDO infoDO = new SilkWagonDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = silkWagonMapper.modifyWagon(infoDO);

        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<SilkWagonVO> list(SearchCommonVO<SilkWagonVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new SilkWagonVO());
        }
        SilkWagonDO infoDO = new SilkWagonDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<SilkWagonDO> doList = silkWagonMapper.listWagon(infoDO);
        List<SilkWagonVO> voList = new ArrayList<>();
        voList = doList.stream().map(silkWagonDO -> {
            SilkWagonVO infoVO = new SilkWagonVO();
            BeanUtils.copyProperties(silkWagonDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 查询所有
     * @param condition
     * @return
     */
    public List<SilkWagonVO> listAll(SearchCommonVO<SilkWagonVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new SilkWagonVO());
        }
        SilkWagonDO infoDO = new SilkWagonDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        log.info("infoDO:" + infoDO.toString());

        List<SilkWagonDO> doList = silkWagonMapper.listWagon(infoDO);
        log.info("doList:" + doList.size());
        List<SilkWagonVO> voList = new ArrayList<>();
        voList = doList.stream().map(silkWagonDO -> {
            SilkWagonVO infoVO = new SilkWagonVO();
            BeanUtils.copyProperties(silkWagonDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<SilkWagonVO> listAllWagonCondition(SearchCommonVO<SilkWagonVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new SilkWagonVO());
        }
        SilkWagonDO infoDO = new SilkWagonDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<SilkWagonDO> doList = silkWagonMapper.listAllWagonCondition(infoDO);
        List<SilkWagonVO> voList = new ArrayList<>();
        voList = doList.stream().map(silkWagonDO -> {
            SilkWagonVO infoVO = new SilkWagonVO();
            BeanUtils.copyProperties(silkWagonDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageCommonVO<SilkWagonVO> listAllWagon(int pageNum, int pageSize){
        PageHelper.orderBy("");
        PageHelper.startPage(pageNum, pageSize);
        PageCommonVO result = new PageCommonVO();
        List<SilkWagonDO> doList = silkWagonMapper.listAllWagon();
        List<SilkWagonVO> voList = new ArrayList<>();
        voList = doList.stream().map(silkWagonDO -> {
            SilkWagonVO infoVO = new SilkWagonVO();
            BeanUtils.copyProperties(silkWagonDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }
}
