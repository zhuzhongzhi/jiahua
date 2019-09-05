package com.xgit.iot.dao.mapper.system;

import com.xgit.iot.dao.entity.system.SysCompanyDO;
import com.xgit.iot.dao.entity.system.SysCompanyUserDO;
import com.xgit.iot.service.vo.system.SysCompanyUserVO;
import com.xgit.iot.service.vo.system.SysCompanyVO;
import com.xgit.iot.dao.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author chenwei
 * @email chenwei@bkrwin.com
 * @date 2018-11-21 13:42:58
 */
@Mapper
public interface SysCompanyMapper extends BaseMapper<SysCompanyVO,SysCompanyDO> {
    int checkName(SysCompanyVO sysCompany);

    int enable(SysCompanyDO sysCompanyDO);

    int delete(String orgId);

    List<SysCompanyUserDO> listCompanyUser(SysCompanyUserVO sysCompanyUserVO);

    List<SysCompanyDO> allList(@Param("pId") String pId);

    List<SysCompanyDO> findCompanys();

    SysCompanyUserDO select(String orgId);

    List<SysCompanyDO> searchList(SysCompanyVO condition);

}
