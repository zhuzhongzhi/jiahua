package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.JiahuaAuthDO;
import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.mapper.system.JiahuaAuthMapper;
import com.xgit.iot.dao.mapper.system.JiahuaUserMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.JiahuaAuthVO;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JiahuaAuthService extends BaseService<JiahuaAuthVO, JiahuaAuthDO>{

    @Autowired
    private JiahuaAuthMapper jiahuaAuthMapper;

    @Autowired
    private GenClient genClient;


    protected JiahuaAuthService() {
        super(JiahuaAuthVO.class, JiahuaAuthDO.class);
    }

    /**
     * 增加
     * @param entity
     * @return
     */
    public Long addAuth(JiahuaAuthVO entity){
        JiahuaAuthDO infoDO = new JiahuaAuthDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaAuthMapper.addAuth(infoDO);

        return infoDO.getJaId();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public Integer modifyAuth(JiahuaAuthVO entity){
        JiahuaAuthDO infoDO = new JiahuaAuthDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaAuthMapper.modifyAuth(infoDO);
        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<JiahuaAuthVO> pageWithCondition(SearchCommonVO<JiahuaAuthVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaAuthVO());
        }
        JiahuaAuthDO infoDO = new JiahuaAuthDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaAuthDO> doList = jiahuaAuthMapper.listWithCondition(infoDO);
        List<JiahuaAuthVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaAuthVO infoVO = new JiahuaAuthVO();
            BeanUtils.copyProperties(lineSpinDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 查询所有不分页
     * @param condition
     * @return
     */
    public List<JiahuaAuthVO> listWithCondition(SearchCommonVO<JiahuaAuthVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaAuthVO());
        }
        JiahuaAuthDO infoDO = new JiahuaAuthDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaAuthDO> doList = jiahuaAuthMapper.listWithCondition(infoDO);
        List<JiahuaAuthVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaAuthVO infoVO = new JiahuaAuthVO();
            BeanUtils.copyProperties(lineSpinDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }
}
