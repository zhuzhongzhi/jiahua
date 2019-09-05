package com.xgit.iot.service;

import com.xgit.iot.infra.FunctionResult;
import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.infra.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by root on 2017-11-29.
 * V:模型类类型，D:实体类类型
 */
public class BaseService<V, D> extends BaseTransVODOService<V, D> {
    BaseMapper baseMapper;

    @Autowired
    private GenClient genClient;

    protected BaseService(Class<V> vClass, Class<D> dClass) {
        super(vClass,dClass);
    }

    protected void addMapper(BaseMapper baseMapper){
        this.baseMapper=baseMapper;
    }

    protected ErrorCode checkParam(V v) {
        if (v == null) {
            return ErrorCode.IllegalArument;
        }
        return ErrorCode.Success;
    }

    public FunctionResult<String> getGenId(){
        ActionResult<String> actionResult = genClient.newGuidText();
        if(actionResult.getCode() != 0){
            return new FunctionResult<>(ErrorCode.CommGetGenIdFailed);
        }
        return new FunctionResult<>(actionResult.getValue());
    }

    public PageCommonVO list(SearchCommonVO<V> condition) {
        PageCommonVO pageCommonVO = new PageCommonVO();
        PageHelper.orderBy("create_date desc");
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<D> doList = baseMapper.list(condition.getFilters());
        List<V> voList = getVOList(doList);
        pageCommonVO.setPageInfo(new PageInfo(doList));
        pageCommonVO.setPageInfoList(voList);
        return pageCommonVO;
    }

    /**
     * DO列表
     * @param filter
     * @return
     */
    public List<D> dolist(V filter) {
        List<D> doList = baseMapper.list(filter);
        return doList;
    }

    /**
     * VO列表
     * @param filter
     * @return
     */
    public List<V> volist(V filter) {
        List<D> doList = baseMapper.list(filter);
        List<V> voList = getVOList(doList);
        return voList;
    }

    public ErrorCode insert(V v) {
        ErrorCode ret = checkParam(v);
        if (ret != ErrorCode.Success) {
            return ret;
        }
        D d = getDO(v);

        int effectRow= baseMapper.insert(d);
        return effectRow > 0 ? ErrorCode.Success : ErrorCode.Failure;
    }

    public ErrorCode update(V v) {
        ErrorCode ret = checkParam(v);
        if (ret != ErrorCode.Success) {
            return ret;
        }
        D d = getDO(v);

        int effectRow= baseMapper.update(d);
        return effectRow > 0 ? ErrorCode.Success : ErrorCode.Failure;
    }

    public V item(String no) {
        D d = (D) baseMapper.item(no);
        V v = getVO(d);
        return v;
    }

    public V item(Integer id) {
        D d = (D) baseMapper.item(id);
        V v = getVO(d);
        return v;
    }

}
