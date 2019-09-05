package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.IusRoleDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.IusRoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface IusRoleMapper extends BaseMapper<IusRoleVO,IusRoleDO>{

    List<IusRoleDO> list(IusRoleDO entity);

    List<IusRoleDO> listAll(IusRoleDO entity);

    List<IusRoleDO> searchList(IusRoleDO entity);

    //查询单个详细信息
    IusRoleDO select(String id);

    //批量删除
    int remove(List<String> ids);

    //更新信息
    int update(IusRoleDO entity);

    //添加信息
    int add(IusRoleDO entity);

    //显示所有的role  给用户管理界面使用
    List<IusRoleDO> listRoles(IusRoleDO entity);

    List<IusRoleDO> searchListRoles(IusRoleDO entity);

    List<IusRoleDO> listAllRoles(IusRoleDO entity);
}
