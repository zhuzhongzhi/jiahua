package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.JiahuaUserAuthDO;
import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.JiahuaUserAuthVO;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 账号信息表 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface JiahuaUserAuthMapper extends BaseMapper<JiahuaUserAuthVO, JiahuaUserAuthDO> {
    List<JiahuaUserAuthDO> listWithCondition(JiahuaUserAuthDO entity);
    int addUserAuth(JiahuaUserAuthDO entity);
    int modifyUserAuth(JiahuaUserAuthDO entity);
}
