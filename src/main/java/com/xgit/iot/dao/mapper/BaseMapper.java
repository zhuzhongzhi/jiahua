package com.xgit.iot.dao.mapper;

import java.util.List;

/**
 * Created by root on 2017-11-30.
 */
public interface BaseMapper<V,D>{
    /**
     * 新增
     * @param d
     * @return
     */
    int insert(D d);

    /**
     * 修改非空字段
     * @param d
     * @return
     */
    int update(D d);

    /**
     * 列表
     * @param v
     * @return
     */
    List<D> list(V v);

    /**
     * 根据no获取详情
     * @param no
     * @return
     */
    D item(String no);

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    D item(Integer id);

    /**
     * 修改可空字段
     * @param record
     * @return
     */
    int updateNullAble(D record);
}
