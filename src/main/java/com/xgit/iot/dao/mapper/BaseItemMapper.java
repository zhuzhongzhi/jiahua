package com.xgit.iot.dao.mapper;

import java.util.List;

/**
 * Created by root on 2017-12-12.
 */
public interface BaseItemMapper<V,D> {

    int insertBatch(List<D> record);

    int delete(String orderNo);

    List<D> list(String orderNo);
}
