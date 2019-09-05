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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SilkWagonService extends BaseService<SilkWagonVO,SilkWagonDO>{

    @Autowired
    private SilkWagonMapper silkWagonMapper;

    @Autowired
    private GenClient genClient;


    protected SilkWagonService() {
        super(SilkWagonVO.class, SilkWagonDO.class);
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
        List<SilkWagonDO> doList = silkWagonMapper.listWagon(infoDO);
        List<SilkWagonVO> voList = new ArrayList<>();
        voList = doList.stream().map(silkWagonDO -> {
            SilkWagonVO infoVO = new SilkWagonVO();
            BeanUtils.copyProperties(silkWagonDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());
        return voList;
    }
}
