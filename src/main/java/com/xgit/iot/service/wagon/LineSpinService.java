package com.xgit.iot.service.wagon;

import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.entity.wagon.LineSpinDO;
import com.xgit.iot.dao.entity.wagon.SilkWagonDO;
import com.xgit.iot.dao.mapper.wagon.LineSpinMapper;
import com.xgit.iot.dao.mapper.wagon.SilkWagonMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.wagon.LineSpinVO;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
import io.swagger.models.auth.In;
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
public class LineSpinService extends BaseService<LineSpinVO, LineSpinDO>{

    @Autowired
    private LineSpinMapper lineSpinMapper;

    @Autowired
    private GenClient genClient;


    protected LineSpinService() {
        super(LineSpinVO.class, LineSpinDO.class);
    }

    /**
     * 增加
     * @param entity
     * @return
     */
    public Long addLineSpin(LineSpinVO entity){
        LineSpinDO infoDO = new LineSpinDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineSpinMapper.addLineSpin(infoDO);

        return infoDO.getLsId();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public Integer modifyLineSpin(LineSpinVO entity){
        LineSpinDO infoDO = new LineSpinDO();
        BeanUtils.copyProperties(entity, infoDO);
        int result = lineSpinMapper.modifyLineSpin(infoDO);
        return result;
    }

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public PageCommonVO<LineSpinVO> pageWithCondition(SearchCommonVO<LineSpinVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        PageCommonVO result = new PageCommonVO();
        if (condition.getFilters() == null) {
            condition.setFilters(new LineSpinVO());
        }
        LineSpinDO infoDO = new LineSpinDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<LineSpinDO> doList = lineSpinMapper.listWithCondition(infoDO);
        List<LineSpinVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            LineSpinVO infoVO = new LineSpinVO();
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
    public List<LineSpinVO> listWithCondition(SearchCommonVO<LineSpinVO> condition){
        PageHelper.orderBy(condition.getSort());
        PageHelper.startPage(condition.getPageNum(), 99999);
        if (condition.getFilters() == null) {
            condition.setFilters(new LineSpinVO());
        }
        LineSpinDO infoDO = new LineSpinDO();
        BeanUtils.copyProperties(condition.getFilters(), infoDO);
        List<LineSpinDO> doList = lineSpinMapper.listWithCondition(infoDO);
        List<LineSpinVO> voList = new ArrayList<>();
        voList = doList.stream().map(lineSpinDO -> {
            LineSpinVO infoVO = new LineSpinVO();
            BeanUtils.copyProperties(lineSpinDO, infoVO);
            return infoVO;
        }).collect(Collectors.toList());

        return voList;
    }

    /**
     * 批量逻辑删除
     *
     * @param ids
     * @return
     */
    @Transactional
    public int remove(List<Long> ids) {
        return lineSpinMapper.remove(ids);
    }
}
