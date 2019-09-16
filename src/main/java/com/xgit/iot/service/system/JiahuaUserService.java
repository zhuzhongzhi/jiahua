package com.xgit.iot.service.system;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.entity.wagon.LineSpinDO;
import com.xgit.iot.dao.mapper.system.JiahuaUserMapper;
import com.xgit.iot.dao.mapper.wagon.LineSpinMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import com.xgit.iot.service.vo.wagon.LineSpinVO;
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
public class JiahuaUserService extends BaseService<JiahuaUserVO, JiahuaUserDO>{

    @Autowired
    private JiahuaUserMapper jiahuaUserMapper;

    @Autowired
    private GenClient genClient;


    protected JiahuaUserService() {
        super(JiahuaUserVO.class, JiahuaUserDO.class);
    }

    /**
     * 增加
     * @param entity
     * @return
     */
    public Long addUser(JiahuaUserVO entity){
        JiahuaUserDO infoDO = new JiahuaUserDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaUserMapper.addUser(infoDO);

        return infoDO.getJuId();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public Integer modifyUser(JiahuaUserVO entity){
        JiahuaUserDO infoDO = new JiahuaUserDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = jiahuaUserMapper.modifyUser(infoDO);
        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<JiahuaUserVO> pageWithCondition(SearchCommonVO<JiahuaUserVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaUserVO());
        }
        JiahuaUserDO infoDO = new JiahuaUserDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaUserDO> doList = jiahuaUserMapper.listWithCondition(infoDO);
        List<JiahuaUserVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaUserVO infoVO = new JiahuaUserVO();
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
    public List<JiahuaUserVO> listWithCondition(SearchCommonVO<JiahuaUserVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new JiahuaUserVO());
        }
        JiahuaUserDO infoDO = new JiahuaUserDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<JiahuaUserDO> doList = jiahuaUserMapper.listWithCondition(infoDO);
        List<JiahuaUserVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            JiahuaUserVO infoVO = new JiahuaUserVO();
            BeanUtils.copyProperties(lineSpinDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    public JiahuaUserVO selectByUserId(String userId){

        JiahuaUserDO result = jiahuaUserMapper.selectByUserId(userId);
        if (result != null) {
            JiahuaUserVO infoVO = new JiahuaUserVO();
            BeanUtils.copyProperties(result, infoVO);
            return infoVO;
        } else {
            return null;
        }
    }

    /**
     * 根据userName查询
     * @param userName
     * @return
     */
    public JiahuaUserVO selectByUserName(String userName){

        JiahuaUserDO result = jiahuaUserMapper.selectByUserName(userName);
        if (result != null) {
            JiahuaUserVO infoVO = new JiahuaUserVO();
            BeanUtils.copyProperties(result, infoVO);
            return infoVO;
        } else {
            return null;
        }
    }
}
