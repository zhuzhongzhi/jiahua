package com.xgit.iot.service;

import com.xgit.iot.dao.mapper.BaseItemMapper;
import com.xgit.iot.infra.ErrorCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对批量操作的数据类型
 * Created by root on 2017-11-29.
 * V:模型类类型，D:实体类类型
 */
public class BaseItemService<V, D> extends BaseTransVODOService<V, D> {

    BaseItemMapper baseItemMapper;

    protected BaseItemService(Class<V> vClass, Class<D> dClass) {
        super(vClass,dClass);
    }

    protected void addMapper(BaseItemMapper baseItemMapper){
        this.baseItemMapper =baseItemMapper;
    }

    public List<V> list(String no) {
        List<D> doList = baseItemMapper.list(no);
        List<V> voList = getVOList(doList);
        return voList;
    }

    public ErrorCode delete(String no) {
        int effectRow= baseItemMapper.delete(no);
        return effectRow > 0 ? ErrorCode.Success : ErrorCode.Failure;
    }

    public ErrorCode insertBatch(List<V> vos) {
        if(vos ==null|| vos.size()<1){
            return ErrorCode.Success;
        }
        List<D> dos=new ArrayList<D>();
        for (V v: vos){
            D d = getDO(v);
            dos.add(d);
        }
        int effectRow= baseItemMapper.insertBatch(dos);
        return effectRow > 0 ? ErrorCode.Success : ErrorCode.Failure;
    }
}
