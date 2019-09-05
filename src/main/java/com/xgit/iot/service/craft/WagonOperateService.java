package com.xgit.iot.service.craft;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.craft.WagonExceptionDO;
import com.xgit.iot.dao.entity.craft.WagonOperateDO;
import com.xgit.iot.dao.entity.system.IusAccountDO;
import com.xgit.iot.dao.entity.wagon.SilkWagonDO;
import com.xgit.iot.dao.entity.wagon.WagonPosDO;
import com.xgit.iot.dao.mapper.craft.WagonOperateMapper;
import com.xgit.iot.dao.mapper.wagon.WagonPosMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.craft.WagonExceptionVO;
import com.xgit.iot.service.vo.craft.WagonOperateVO;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WagonOperateService extends BaseService<WagonOperateVO, WagonOperateDO>{

    @Autowired
    private WagonOperateMapper wagonOperateMapper;

    @Autowired
    private GenClient genClient;


    protected WagonOperateService() {
        super(WagonOperateVO.class, WagonOperateDO.class);
    }


    /**
     * 工艺流程列表查询
     * @return
     */
    public List<WagonOperateVO> listWagonOperate(SearchCommonVO<WagonOperateVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        if (condition.getFilters() == null) {
            condition.setFilters(new WagonOperateVO());
        }
        WagonOperateDO infoDO = new WagonOperateDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);

        List<WagonOperateDO> doList = wagonOperateMapper.listWagonOperate(infoDO);
        List<WagonOperateVO> voList = new ArrayList<>();
        voList = doList.stream().map(wagonPosVO -> {
            WagonOperateVO infoVO = new WagonOperateVO();
            BeanUtils.copyProperties(wagonPosVO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 工艺流程分页查询
     * @return
     */
    public PageCommonVO<WagonOperateVO> pageWagonOperate(SearchCommonVO<WagonOperateVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new WagonOperateVO());
        }
        WagonOperateDO infoDO = new WagonOperateDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);

        List<WagonOperateDO> doList = wagonOperateMapper.listWagonOperate(infoDO);
        List<WagonOperateVO> voList = new ArrayList<>();
        voList = doList.stream().map(wagonPosVO -> {
            WagonOperateVO infoVO = new WagonOperateVO();
            BeanUtils.copyProperties(wagonPosVO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        result.setPageInfo(new PageInfo(voList));
        return result;
    }

    /**
     * 新增操作
     * @param entity
     * @return
     */
    public Long addOperate(WagonOperateVO entity){
        WagonOperateDO infoDO = new WagonOperateDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = wagonOperateMapper.addOperate(infoDO);
        return infoDO.getOpId();
    }

    /**
     * 修改操作
     * @param entity
     * @return
     */
    public int modifyOperate(WagonOperateVO entity){
        WagonOperateDO infoDO = new WagonOperateDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = wagonOperateMapper.modifyOperate(infoDO);
        return result;
    }
}
