package com.xgit.iot.service;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2017-12-12.
 */
public class BaseTransVODOService<V, D> {

    private Class<D> dClass;

    private Class<V> vClass;

    protected BaseTransVODOService(Class<V> vClass, Class<D> dClass) {
        this.vClass = vClass;
        this.dClass = dClass;
    }

    protected D getDO(V dataVO) {
        D dataDO;
        try {
            dataDO = dClass.newInstance();
        } catch (Exception e) {
            return null;
        }
        if (dataVO == null) {
            return null;
        }
        BeanUtils.copyProperties(dataVO, dataDO);
        return dataDO;
    }

    protected V getVO(D dataDO) {
        V dataVO ;
        try {
            dataVO = vClass.newInstance();
        } catch (Exception e) {
            return null;
        }
        if (dataDO == null) {
            return null;
        }
        BeanUtils.copyProperties(dataDO, dataVO);
        return dataVO;
    }

    protected List<V> getVOList(List<D> doList) {
        List<V> voList = new ArrayList<>();
        if (doList == null) {
            return voList;
        }
        for (D dataDO : doList) {
            if (dataDO == null) {
                continue;
            }
            V viewVo = getVO(dataDO);
            voList.add(viewVo);
        }
        return voList;
    }
}
