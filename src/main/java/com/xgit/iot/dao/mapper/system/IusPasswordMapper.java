package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.IusPasswordDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.system.IusPasswordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 密码信息 Mapper 接口
 * </p>
 *
 * @author f00lish123
 * @since 2019-04-09
 */
@Mapper
public interface IusPasswordMapper extends BaseMapper<IusPasswordVO,IusPasswordDO>{


    //批量删除
    int remove(List<String> userIds);

    //更新信息
    int updateForUser(IusPasswordDO entity);

    //添加信息
    int add(IusPasswordDO entity);

}
