package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.IusProfileDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.IusProfileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户资料信息 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface IusProfileMapper  extends BaseMapper<IusProfileVO,IusProfileDO>{

    List<IusProfileDO> list(IusProfileDO entity);

    List<IusProfileDO> listAll(IusProfileDO entity);

    List<IusProfileDO> searchList(IusProfileDO entity);

    //查询单个详细信息
    IusProfileDO select(String id);

    String selectForWorkPersonnl(String workPersonnelId);

    int countForWorkPersonnel(String workPersonnelId);

    //批量删除
    int remove(List<String> ids);

    //更新信息
    int update(IusProfileDO entity);

    //添加信息
    int add(IusProfileDO entity);


    IusProfileDO getById(String id);


    int getShowRegister();

    IusProfileDO getUserProfileById(String id);
}
