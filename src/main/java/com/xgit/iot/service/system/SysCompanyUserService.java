package com.xgit.iot.service.system;

import com.xgit.iot.dao.entity.system.SysCompanyDO;
import com.xgit.iot.dao.entity.system.SysCompanyUserDO;
import com.xgit.iot.dao.mapper.system.SysCompanyMapper;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.SysCompanyUserVO;
import com.bkrwin.ufast.feign.AuthClient;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysCompanyUserService extends BaseService<SysCompanyUserVO,SysCompanyUserDO>{
	@Autowired
	private SysCompanyMapper sysCompanyMapper;



	@Autowired
	private SysSequenceService sysSequenceService;

	@Autowired
	private AuthClient authClient;

	public SysCompanyUserService(){super(SysCompanyUserVO.class,SysCompanyUserDO.class);};

	@PostConstruct
	public void init(){super.addMapper(sysCompanyMapper);}

	/**
	 * 查询
	 * @param orgId
	 * @return
	 */
	public SysCompanyUserVO select(String orgId){
		SysCompanyUserDO userDO = sysCompanyMapper.select(orgId);
		List<SysCompanyDO> companys = sysCompanyMapper.findCompanys();
		for (SysCompanyDO companyDO : companys){
			if (userDO.getpId().equals(companyDO.getOrgId())){
				userDO.setpOrgName(companyDO.getOrgName());
			}
		}
		SysCompanyUserVO userVO = new SysCompanyUserVO();
		BeanUtils.copyProperties(userDO,userVO);
		return userVO;
	}

	/**
	 * 分页显示 有权限
	 * @param condition
	 * @return
	 */
	public PageCommonVO list(SearchCommonVO<SysCompanyUserVO> condition){
		PageCommonVO pageCommonVO = new PageCommonVO();
		if (condition.getSort() == null || "".equals(condition.getSort())){
			condition.setSort("org_code asc");
		}
		PageHelper.orderBy(condition.getSort());
		PageHelper.startPage(condition.getPageNum(),condition.getPageSize());
		if (condition.getFilters() == null) {
			condition.setFilters(new SysCompanyUserVO());
		}
		if (StringUtils.isEmpty(condition.getFilters().getOrgId())) {
			condition.getFilters().setOrgId("0");
		}

		List<SysCompanyUserDO> userDOS = sysCompanyMapper.listCompanyUser(condition.getFilters());
		List<SysCompanyDO> companyDOS = sysCompanyMapper.findCompanys();
		for (SysCompanyUserDO userDO : userDOS) {
			for (SysCompanyDO companyDO : companyDOS) {
				if (userDO.getpId().equals(companyDO.getOrgId())){
					userDO.setpOrgName(companyDO.getOrgName());
				}
			}
		}

		List<SysCompanyUserVO> voList = getVOList(userDOS);
		pageCommonVO.setPageInfo(new PageInfo(userDOS));
		pageCommonVO.setPageInfoList(voList);
		return pageCommonVO;



//		//获取所有的机构信息
//		List<SysCompanyUserDO> userDOS = sysCompanyMapper.listCompanyUser(condition.getFilters());
//		List<SysCompanyDO> companyDOS = sysCompanyMapper.findCompanys();
//		for (SysCompanyUserDO userDO : userDOS){
//			for (SysCompanyDO companyDO : companyDOS){
//				if (userDO.getpId().equals(companyDO.getOrgId())){
//					userDO.setpOrgName(companyDO.getOrgName());
//				}
//			}
//		}
//		//递归排序
//		List<SysCompanyUserDO> sysCompanyUserDOS = findCompanys(userDOS);
//
//		//获取分页中所需要的数据
//		List<SysCompanyUserDO> userDOList = new ArrayList<>();
//		int first = condition.getPageSize() * (condition.getPageNum() - 1) + 1;
//		int last = condition.getPageSize() * condition.getPageNum();
//		if (last > sysCompanyUserDOS.size()){
//			for (int i = first; i <= sysCompanyUserDOS.size(); i++){
//				userDOList.add(sysCompanyUserDOS.get(i-1));
//			}
//		}
//		else {
//			for (int i = first; i <= last; i++){
//				userDOList.add(sysCompanyUserDOS.get(i-1));
//			}
//		}
//
//		//分页数据转换格式
//		List<SysCompanyUserVO> voList = getVOList(userDOList);
//
//		//将所有数据封装进pageInfo，得到对应的分页参数
//		PageInfo<SysCompanyUserDO> sysCompanyUserDOPageInfo = new PageInfo<>(sysCompanyUserDOS);
//
//
//		Integer pageNum = condition.getPageNum();
//		Integer pageSize = condition.getPageSize();
//		Integer size = sysCompanyUserDOS.size() - ((pageNum - 1)*pageSize);
//		Integer startRow;
//		Integer endRow;
//		if (size == 0){
//			startRow = 0;
//			endRow = 0;
//		}else {
//			startRow = first;
//			endRow = startRow -1 + size;
//		}
//		if (last > sysCompanyUserDOS.size()){
//			endRow = sysCompanyUserDOS.size();
//		}
//		//计算导航页
//		int[] navigatePageNums = getNavigatePageNums(condition.getPageSize(), sysCompanyUserDOS.size());
//		Integer pages;
//		if (navigatePageNums.length == 0) {
//			pages = 0;
//		}else {
//			pages = navigatePageNums[navigatePageNums.length-1];
//		}
//
//		int[] ints;
//		//当总页数小于等于8时候
//		if (pages <= 8){
//			ints = new int[pages];
//			for (int i = 0; i < pages; i++){
//				ints[i] = i + 1;
//			}
//		}
//		//当总页数大于导航页码8
//		else {
//			ints = new int[8];
//			int startNum = pageNum - 8 / 2;
//			int endNum = pageNum + 8 / 2;
//			if (startNum < 1){
//				startNum =1;
//				//从最前navi页
//				for (int i = 0; i < 8; i++){
//					ints[i] = startNum++;
//				}
//			}else if (endNum > pages){
//				endNum = pages;
//				//从最后navi页
//				for (int i = 8 -1; i >= 0; i--){
//					ints[i] = endNum--;
//				}
//			}else {
//				//所有中间页码
//				for (int i = 0 ; i < 8; i ++){
//					ints[i] =startNum++;
//				}
//			}
//		}
//
//
//		Integer firstPage = 0;
//		Integer lastPage=0;
//		Integer prePage=0;
//		Integer nextPage=0;
//
//		if (ints != null && ints.length > 0){
//			firstPage = ints[0];
//			lastPage = ints[ints.length - 1];
//			if (pageNum > 1){
//				prePage = pageNum -1;
//			}
//			if (pageNum < pages){
//				nextPage = pageNum + 1;
//			}
//		}
//
//		Boolean isFirstPage = pageNum == 1;
//		Boolean isLastPage = pageNum == pages;
//		Boolean hasPreviousPage = pageNum >1;
//		Boolean hasNextPage = pageNum < pages;
//
//		sysCompanyUserDOPageInfo.setPageNum(pageNum);
//		sysCompanyUserDOPageInfo.setPageSize(pageSize);
//		sysCompanyUserDOPageInfo.setSize(size);
//		sysCompanyUserDOPageInfo.setStartRow(startRow);
//		sysCompanyUserDOPageInfo.setEndRow(endRow);
//		sysCompanyUserDOPageInfo.setPages(pages);
//		sysCompanyUserDOPageInfo.setFirstPage(firstPage);
//		sysCompanyUserDOPageInfo.setPrePage(prePage);
//		sysCompanyUserDOPageInfo.setNextPage(nextPage);
//		sysCompanyUserDOPageInfo.setLastPage(lastPage);
//		sysCompanyUserDOPageInfo.setIsFirstPage(isFirstPage);
//		sysCompanyUserDOPageInfo.setIsLastPage(isLastPage);
//		sysCompanyUserDOPageInfo.setHasPreviousPage(hasPreviousPage);
//		sysCompanyUserDOPageInfo.setHasNextPage(hasNextPage);
//		sysCompanyUserDOPageInfo.setNavigatepageNums(ints);
//		pageCommonVO.setPageInfo(sysCompanyUserDOPageInfo);
//
//		//分页数据封装
//		pageCommonVO.setPageInfoList(voList);
//		return pageCommonVO;


	}


	//递归排序
	public List<SysCompanyUserDO> findCompanys(List<SysCompanyUserDO> treeNodes){
		List<SysCompanyUserDO> trees = new ArrayList<>();
		for (SysCompanyUserDO userDO : treeNodes){
			if ("-1".equals(userDO.getpId().toString().trim())){
				trees.add(userDO);
				for (SysCompanyUserDO userDO1 : treeNodes){
					if (userDO.getOrgId().equals(userDO1.getpId())){
						trees.add(userDO1);
						for (SysCompanyUserDO userDO2 : treeNodes){
							if (userDO1.getOrgId().equals(userDO2.getpId())){
								trees.add(userDO2);
								for (SysCompanyUserDO userDO3 : treeNodes){
									if (userDO2.getOrgId().equals(userDO3.getpId())){
										trees.add(userDO3);
									}
								}
							}
						}
					}
				}
			}
		}
		return trees;
	}


	//不分页查询的数据
	public List<SysCompanyUserDO> getList(int pageNum,int pageSize,SysCompanyUserVO sysCompanyUserVO){
		List<SysCompanyUserDO> userDOS = sysCompanyMapper.listCompanyUser(sysCompanyUserVO);
		List<SysCompanyDO> companyDOS = sysCompanyMapper.findCompanys();
		for (SysCompanyUserDO userDO : userDOS){
			for (SysCompanyDO companyDO : companyDOS){
				if (userDO.getpId().equals(companyDO.getOrgId())){
					userDO.setpOrgName(companyDO.getOrgName());
				}
			}
		}
		return userDOS;
	}



	public int[] getNavigatePageNums(int pageSize,int size){
		int z = size / pageSize;
		int y = size % pageSize;
		int[] ints ;
		if (y == 0){
			ints = new int[z];
			for (int i = 1; i <= z; i++){
				ints[i-1]=i;
			}
		}else {
			ints = new int[z+1];
			for (int i = 1; i <= z+1; i++){
				ints[i-1]=i;
			}
		}
		return ints;
	}
}
