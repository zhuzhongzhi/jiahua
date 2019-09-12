package com.xgit.iot.dao.mapper.wagon;

import com.xgit.iot.dao.entity.wagon.LineSpinDO;
import com.xgit.iot.dao.mapper.BaseMapper;
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
public interface LineSpinMapper extends BaseMapper<LineSpinVO,LineSpinDO> {
    List<LineSpinDO> listWithCondition(LineSpinDO entity);
    int addLineSpin(LineSpinDO entity);
    int modifyLineSpin(LineSpinDO entity);
}
