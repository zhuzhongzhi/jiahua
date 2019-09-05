package com.xgit.iot.dao.mapper.wagon;

import com.xgit.iot.dao.entity.wagon.WagonPosDO;
import com.xgit.iot.dao.mapper.BaseMapper;
import com.xgit.iot.service.vo.wagon.WagonPosVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

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
public interface WagonPosMapper extends BaseMapper<WagonPosVO,WagonPosDO> {
    WagonPosDO wagonPos(@Param("code") String code);
    List<WagonPosDO> listWagonPos(@Param("code") String code);
}
