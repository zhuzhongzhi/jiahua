package com.xgit.iot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableSplitMapper {
    int count(String curMonthYear);

    int createTable(@Param("curMonthYear")String curMonthYear);
}
