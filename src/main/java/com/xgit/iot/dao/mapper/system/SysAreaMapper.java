package com.xgit.iot.dao.mapper.system;


import com.xgit.iot.dao.entity.system.SysAreaDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.SysAreaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 城市表
 *
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaVO,SysAreaDO> {


    List<SysAreaDO> findAreas(SysAreaDO entity);

    SysAreaDO findAreaByCode(String code);


}
