package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.JiahuaUserAuthDO;
import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.mapper.system.JiahuaUserAuthMapper;
import com.xgit.iot.dao.mapper.system.JiahuaUserMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.JiahuaUserAuthVO;
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
public class JiahuaUserAuthService extends BaseService<JiahuaUserAuthVO, JiahuaUserAuthDO>{

    @Autowired
    private JiahuaUserAuthMapper jiahuaUserAuthMapper;

    @Autowired
    private GenClient genClient;


    protected JiahuaUserAuthService() {
        super(JiahuaUserAuthVO.class, JiahuaUserAuthDO.class);
    }

    /**
     * 增加
     * @param entity
     * @return
     */
    public Long addUserAuth(JiahuaUserAuthVO entity){
        JiahuaUserAuthDO infoDO = new JiahuaUserAuthDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaUserAuthMapper.addUserAuth(infoDO);

        return infoDO.getJuaId();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public Integer modifyUserAuth(JiahuaUserAuthVO entity){
        JiahuaUserAuthDO infoDO = new JiahuaUserAuthDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaUserAuthMapper.modifyUserAuth(infoDO);
        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<JiahuaUserAuthVO> pageWithCondition(SearchCommonVO<JiahuaUserAuthVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaUserAuthVO());
        }
        JiahuaUserAuthDO infoDO = new JiahuaUserAuthDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaUserAuthDO> doList = jiahuaUserAuthMapper.listWithCondition(infoDO);
        List<JiahuaUserAuthVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaUserAuthVO infoVO = new JiahuaUserAuthVO();
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
    public List<JiahuaUserAuthVO> listWithCondition(SearchCommonVO<JiahuaUserAuthVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaUserAuthVO());
        }
        JiahuaUserAuthDO infoDO = new JiahuaUserAuthDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaUserAuthDO> doList = jiahuaUserAuthMapper.listWithCondition(infoDO);
        List<JiahuaUserAuthVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaUserAuthVO infoVO = new JiahuaUserAuthVO();
            BeanUtils.copyProperties(lineSpinDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }
}
