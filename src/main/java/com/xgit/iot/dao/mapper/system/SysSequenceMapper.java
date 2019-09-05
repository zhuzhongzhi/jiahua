package com.xgit.iot.dao.mapper.system;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysSequenceMapper {

    Integer getSeqByCode(Integer code);

    int updateSeqByCode(@Param("code") Integer code, @Param("no") Integer no);

    int resetSequence();
}
