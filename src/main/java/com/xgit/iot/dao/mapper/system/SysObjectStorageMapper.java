package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.SysObjectStorageDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.SysObjectStorageVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 对象存储服务表
 *
 * @author huzhen
 * @email 617694858@qq.com
 * @date 2018-11-23 09:52:32
 */
@Mapper
public interface SysObjectStorageMapper extends BaseMapper<SysObjectStorageVO,SysObjectStorageDO> {
	
}
