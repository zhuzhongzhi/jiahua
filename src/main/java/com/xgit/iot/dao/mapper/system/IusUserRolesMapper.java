package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.IusUserRolesDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.IusUserRolesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface IusUserRolesMapper extends BaseMapper<IusUserRolesVO,IusUserRolesDO>{

    //查询单个详细信息
    IusUserRolesDO select(String userId);

    //批量删除
    int remove(List<String> userIds);

    //更新信息 updateForUser
    int updateForUser(IusUserRolesDO entity);

    //添加信息
    int add(IusUserRolesDO entity);



}
