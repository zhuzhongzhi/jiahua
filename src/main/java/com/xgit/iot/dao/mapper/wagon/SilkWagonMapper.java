package com.xgit.iot.dao.mapper.wagon;

import com.xgit.iot.dao.entity.wagon.SilkWagonDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.wagon.SilkWagonVO;
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
public interface SilkWagonMapper extends BaseMapper<SilkWagonVO,SilkWagonDO> {
    List<SilkWagonDO> listWagon(SilkWagonDO entity);
    List<SilkWagonDO> listAllWagon();
    List<SilkWagonDO> listAllWagonCondition(SilkWagonDO entity);
    int addWagon(SilkWagonDO entity);
}
