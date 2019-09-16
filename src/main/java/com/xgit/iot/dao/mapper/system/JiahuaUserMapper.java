package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.JiahuaUserDO;
import com.xgit.iot.dao.entity.wagon.LineSpinDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import com.xgit.iot.service.vo.wagon.LineSpinVO;
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
public interface JiahuaUserMapper extends BaseMapper<JiahuaUserVO, JiahuaUserDO> {
    List<JiahuaUserDO> listWithCondition(JiahuaUserDO entity);
    int addUser(JiahuaUserDO entity);
    int modifyUser(JiahuaUserDO entity);
    JiahuaUserDO selectByUserId(String userId);
    JiahuaUserDO selectByUserName(String userName);
}
