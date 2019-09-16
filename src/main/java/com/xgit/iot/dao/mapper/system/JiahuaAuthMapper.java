package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.JiahuaAuthDO;
import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.JiahuaAuthVO;
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
public interface JiahuaAuthMapper extends BaseMapper<JiahuaAuthVO, JiahuaAuthDO> {
    List<JiahuaAuthDO> listWithCondition(JiahuaAuthDO entity);
    int addAuth(JiahuaAuthDO entity);
    int modifyAuth(JiahuaAuthDO entity);
}
