package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.IusAccountDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.IusAccountVO;
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
public interface IusAccountMapper extends BaseMapper<IusAccountVO,IusAccountDO> {


    //查询单个详细信息
    IusAccountDO select(String userId);

    //批量删除
    int remove(List<String> userIds);


    //更新信息 updateForUser
    int updateForUser(IusAccountDO entity);

    //添加信息
    int add(IusAccountDO entity);

}
