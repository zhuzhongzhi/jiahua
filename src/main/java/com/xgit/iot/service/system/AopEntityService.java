package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.AopEntity;
import com.xgit.iot.dao.entity.system.JiahuaAuthDO;
import com.xgit.iot.dao.mapper.system.AopEntityMapper;
import com.xgit.iot.dao.mapper.system.JiahuaAuthMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.JiahuaAuthVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AopEntityService extends BaseService<AopEntity, AopEntity>{

    @Autowired
    private AopEntityMapper aopEntityMapper;

    @Autowired
    private GenClient genClient;


    protected AopEntityService() {
        super(AopEntity.class, AopEntity.class);
    }

    /**
     * 增加
     * @param entity
     * @return
     */
    public Long addAopEntity(AopEntity entity){
        int result = aopEntityMapper.addAopEntity(entity);

        return entity.getLogId();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public Integer modifyAopEntity(AopEntity entity){
        int result = aopEntityMapper.modifyAopEntity(entity);
        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<AopEntity> pageWithCondition(SearchCommonVO<AopEntity> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new AopEntity());
        }

        List<AopEntity> doList = aopEntityMapper.listWithCondition(condition.getFilters());

        result.setPageInfo(new PageInfo(doList));
        return result;
    }

    /**
     * 查询所有不分页
     * @param condition
     * @return
     */
    public List<AopEntity> listWithCondition(SearchCommonVO<AopEntity> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(1, 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new AopEntity());
        }

        List<AopEntity> doList = aopEntityMapper.listWithCondition(condition.getFilters());

        return doList;
    }

    /**
     * 批量逻辑删除
     *
     * @param ids
     * @return
     */
    @Transactional
    public int remove(List<Long> ids) {
        return aopEntityMapper.remove(ids);
    }

    /**
     * 逻辑删除所有记录
     *
     * @return
     */
    @Transactional
    public int clear() {
        return aopEntityMapper.clear();
    }
}
