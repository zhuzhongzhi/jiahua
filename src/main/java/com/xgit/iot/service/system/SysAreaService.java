package com.xgit.iot.service.system;

import com.xgit.iot.dao.entity.system.SysAreaDO;
import com.xgit.iot.dao.mapper.system.SysAreaMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.SysAreaVO;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 城市表
 */
@Service
public class SysAreaService extends BaseService<SysAreaVO,SysAreaDO> {
    @Autowired
    private SysAreaMapper sysAreaMapper;

    public SysAreaService(){super(SysAreaVO.class,SysAreaDO.class);}

    @PostConstruct
    public void init(){super.addMapper(sysAreaMapper);}

	@Override
	public SysAreaVO item(String code){
		return super.item(code);
	}
	
	@Override
	public PageCommonVO list(SearchCommonVO<SysAreaVO> condition){
			PageCommonVO pageCommonVO = new PageCommonVO();
			PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
			List<SysAreaDO> doList = sysAreaMapper.list(condition.getFilters());
			List<SysAreaVO> voList = getVOList(doList);
			pageCommonVO.setPageInfo(new PageInfo(doList));
			pageCommonVO.setPageInfoList(voList);
			return pageCommonVO;
	}
	
	@Override
	public ErrorCode insert(SysAreaVO plaBasicCity){
		return super.insert(plaBasicCity);
	}
	
	@Override
	public ErrorCode update(SysAreaVO plaBasicCity){
		return super.update(plaBasicCity);
	}


	/**
	 * 查询地址区域
	 * @param model
	 * @return
	 */
	public List<SysAreaVO> findAreas(SysAreaVO model){
    	SysAreaDO sysAreaDO = new SysAreaDO();
		BeanUtils.copyProperties(model,sysAreaDO);
		List<SysAreaDO> areaDOS = sysAreaMapper.findAreas(sysAreaDO);
		List<SysAreaVO> areaVOS = new ArrayList<>();
		for (SysAreaDO areaDO : areaDOS){
			SysAreaVO areaVO = new SysAreaVO();
			BeanUtils.copyProperties(areaDO,areaVO);
			areaVOS.add(areaVO);
		}
		return areaVOS;
	}


	public SysAreaDO findAreaByCode(String code){
		SysAreaDO areaByCode = sysAreaMapper.findAreaByCode(code);
		return areaByCode;
	}
}
