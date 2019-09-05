package com.xgit.iot.service.system;

import com.bkrwin.ufast.dto.UserDetailDTO;
import com.bkrwin.ufast.dto.WorkSpaceDTO;
import com.bkrwin.ufast.feign.AuthClient;
import com.bkrwin.ufast.feign.GenClient;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.PageCommonVO;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.bkrwin.ufast.infra.util.Ref;
import com.xgit.iot.dao.entity.system.SysCompanyDO;
import com.xgit.iot.dao.mapper.system.SysCompanyMapper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.constants.Constants;
import com.xgit.iot.service.BaseService;
import com.xgit.iot.service.vo.system.SysCompanyVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class SysCompanyService extends BaseService<SysCompanyVO,SysCompanyDO>{
    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    @Autowired
    private SysSequenceService sysSequenceService;

    @Autowired
    private AuthClient authClient;


    @Autowired
    private GenClient genClient;

    public SysCompanyService(){super(SysCompanyVO.class,SysCompanyDO.class);};

    @PostConstruct
    public void init(){super.addMapper(sysCompanyMapper);}

	@Override
	public SysCompanyVO item(String orgId){
		return super.item(orgId);
	}

	@Override
	public PageCommonVO list(SearchCommonVO<SysCompanyVO> condition){
		return super.list(condition);
	}

	public List<SysCompanyDO> allList(SysCompanyVO condition) {
		List<SysCompanyDO> doList = sysCompanyMapper.list(condition);
		return  doList;
	}

	/**
	 * 1、新增公司
	 * 2、新增该公司管理员
	 * @param sysCompany
	 * @return
	 */
	public ErrorCode insertCompany(SysCompanyVO sysCompany,UserDetailDTO userDetailDTO)throws Exception{
		Ref<String> orgIdRef = new Ref<>(StringUtils.EMPTY);

		// 校验企业名称
		int nameCount = sysCompanyMapper.checkName(sysCompany);
		if (nameCount > 0) {
			return ErrorCode.CpyNameHasExist;
		}

		// 获取OrgId
		ErrorCode retCode = getCompanyOrgId(orgIdRef);
		if(retCode != ErrorCode.Success){
			return retCode;
		}
		sysCompany.setOrgId(orgIdRef.get());
		sysCompany = AddOperationRecords(sysCompany, userDetailDTO);

		//新增auth
		retCode = buildWorkSpace(sysCompany);
		if(retCode != ErrorCode.Success){
			return retCode;
		}

		//新增企业
		retCode = super.insert(sysCompany);
		if(retCode != ErrorCode.Success){
			return retCode;
		}

		return ErrorCode.Success;
	}


	public ErrorCode update(SysCompanyVO sysCompany,UserDetailDTO userDetailDTO){
		// 校验企业名称
		int nameCount = sysCompanyMapper.checkName(sysCompany);
		if (nameCount > 0) {
			return ErrorCode.CpyNameHasExist;
		}
		sysCompany = ModifyOperationRecords(sysCompany, userDetailDTO);
		return super.update(sysCompany);
	}


	private SysCompanyVO AddOperationRecords(SysCompanyVO sysCompany,UserDetailDTO userDetailDTO){
		sysCompany.setCreateUserId(userDetailDTO.getUserId());
		sysCompany.setCreateUserName(userDetailDTO.getName());
		sysCompany.setCreateDate(new Date());
		sysCompany.setModifyUserId(userDetailDTO.getUserId());
		sysCompany.setModifyUserName(userDetailDTO.getName());
		sysCompany.setModifyDate(new Date());
		return sysCompany;
	}

	private SysCompanyVO ModifyOperationRecords(SysCompanyVO sysCompany,UserDetailDTO userDetailDTO){
		sysCompany.setModifyUserId(userDetailDTO.getUserId());
		sysCompany.setModifyUserName(userDetailDTO.getName());
		sysCompany.setModifyDate(new Date());
		return sysCompany;
	}

	private ErrorCode buildWorkSpace(SysCompanyVO sysCompany)throws Exception {
		WorkSpaceDTO spaceDTO = new WorkSpaceDTO();
		spaceDTO.setTempId(Constants.Company_Template);
		spaceDTO.setName(sysCompany.getOrgName());
		spaceDTO.setId(sysCompany.getOrgId());
		spaceDTO.setSite(Constants.Site.Machine_Monitor);
		spaceDTO.setType("1");
		spaceDTO.setAccount(sysCompany.getLoginName());
		spaceDTO.setPassword(Constants.Default_Password);
		ActionResult ret;
		try {
			ret  = authClient.addWrokSpace(spaceDTO);
		} catch (Exception ex) {
			return ErrorCode.AddWorkSpaceExpection;
		}
		if (ErrorCode.Success.getCode() != ret.getCode()) {
			return ErrorCode.AddWorkSpaceFail;
		}
		return ErrorCode.Success;
	}

	/**
	 * 获取OrgId
	 * @return
	 */
	private ErrorCode getCompanyOrgId(Ref<String> orgIdRef) {
		Integer no = sysSequenceService.getSeqByCode(Constants.SequenceType.COMPANY);
		ErrorCode code = sysSequenceService.updateSeqByCode(Constants.SequenceType.COMPANY, no);
		if (code != ErrorCode.Success) {
			return ErrorCode.CompanyNoGenerateError;
		}
		orgIdRef.set(no.toString());
		return ErrorCode.Success;
	}

	/**
	 * 停用启用
	 * @param enable
	 * @param enable
	 * @return
	 */
	public ErrorCode enable(String orgId, int enable){
		SysCompanyDO sysCompanyDO = new SysCompanyDO();
		sysCompanyDO.setOrgId(orgId);
		sysCompanyDO.setEnabled(enable);
		int result = sysCompanyMapper.enable(sysCompanyDO);
		if(result <= 0){
			return ErrorCode.EnableCompanyFail;
		}

		return ErrorCode.Success;
	}

	/**
	 * 删除
	 */
	public ErrorCode delete(String orgId){
		int result = sysCompanyMapper.delete(orgId);
		if(result <= 0){
			return ErrorCode.DeleteCompanyFail;
		}
		return ErrorCode.Success;
	}
	/**
	 * 批量删除
	 */
	public ErrorCode batchDeleteCompany(List<String> orgIdList){
		for(String item : orgIdList){
			int result = sysCompanyMapper.delete(item);
			if(result <= 0){
				return ErrorCode.DeleteCompanyFail;
			}
		}

		return ErrorCode.Success;
	}

	/**
	 * 根据OrgId获取OrgName
	 * @param orgId
	 * @return
	 */
	public String getOrgName(String orgId)
	{
		SysCompanyVO sysCompanyVO = item(orgId);
		if(sysCompanyVO == null){
			return StringUtils.EMPTY;
		}

		return sysCompanyVO.getOrgName();
	}

	/**
	 * 递归查询机构
	 */
	public List<Map> findCompanys(){
		List<SysCompanyDO> companyDOSList = sysCompanyMapper.findCompanys();
		List<Map> mapList = new ArrayList<>();
		for (int i = 0; companyDOSList != null&& i < companyDOSList.size(); i++){
			Map<String,Object> map = new HashMap<>();
			SysCompanyDO sysCompanyDO = companyDOSList.get(i);
			map.put("title",sysCompanyDO.getOrgName());
			map.put("key",sysCompanyDO.getOrgId());
			map.put("orgName",sysCompanyDO.getOrgName());
			map.put("orgId",sysCompanyDO.getOrgId());
			map.put("children",new ArrayList<Map>());
			map.put("pId",sysCompanyDO.getpId());
			mapList.add(map);
		}
		mapList = buildByRecursive(mapList);

		return mapList;
	}

	public List<Map> buildByRecursive(List<Map> treeNodes){
		List<Map> trees = new ArrayList<>();
		for (Map treeNode : treeNodes){
			if ("-1".equals(treeNode.get("pId").toString().trim())){
				trees.add(findChildren(treeNode,treeNodes));
			}
		}
		return trees;
	}

	public Map findChildren(Map treeNode, List<Map> treeNodes){
		for (Map it : treeNodes){
			if (treeNode.get("orgId").equals(it.get("pId"))){
				Map children = findChildren(it,treeNodes);
				((ArrayList)treeNode.get("children")).add(children);
			}
		}
		return treeNode;
	}



	/**
	 * 根据机构id递归查询父级机构id
	 */
	public String findParentIds(String orgId, String parentId){

		SysCompanyDO company = sysCompanyMapper.item(orgId);

		if (null == company || null == company.getpId()) {
			return "";
		}

		if ("-1".equals(company.getpId().trim())) {
			parentId = company.getpId() + "," + parentId;
			return parentId;
		} else {
			parentId = company.getpId() + "," + parentId;
			return findParentIds(company.getpId(), parentId);
		}
	}

	/**
	 * 根据机构id递归查询子级机构ids
	 */
	public String findChildIds(String orgId){

		StringBuilder childIds = new StringBuilder(orgId);

		SysCompanyDO sysCompanyDO = new SysCompanyDO();
		sysCompanyDO.setOrgId(orgId);
		sysCompanyDO.setEnabled(1);
		sysCompanyDO.setDeleted(0);
		List<SysCompanyDO> orgList = sysCompanyMapper.allList(orgId);

		buildChildNodes(sysCompanyDO,orgList);

		if (null != sysCompanyDO.getChildren() && sysCompanyDO.getChildren().size() > 0) {
			for (SysCompanyDO sysCompany : sysCompanyDO.getChildren()) {
				childIds.append(",").append(sysCompany.getOrgId());
			}
		}

		return childIds.toString();

	}

	/**
	 * 递归子节点
	 *
	 * @param node
	 */
	public void buildChildNodes(SysCompanyDO node, List<SysCompanyDO> orgsV) {
		List<SysCompanyDO> children = getChildNodes(node, orgsV);
		if (!children.isEmpty()) {
			for (SysCompanyDO child : children) {
				buildChildNodes(child,orgsV);
			}
			node.setChildren(children);
		}
	}

	/**
	 * 获取父节点下所有的子节点
	 *
	 * @param nodes
	 * @return
	 */
	public List<SysCompanyDO> getChildNodes(SysCompanyDO nodes,List<SysCompanyDO> orgsV) {
		List<SysCompanyDO> childNodes = new ArrayList<>();
		for (SysCompanyDO n : orgsV) {
			if (nodes.getOrgId().equals(n.getpId())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}


    /**
     * 带过滤无车辆信息的递归查询
     * @return
     */
	public List<Map> findCompanysFilter() {
		List<SysCompanyDO> companyDOS = sysCompanyMapper.findCompanys();
		List<Map> mapList = new ArrayList<>();
		for (int i = 0; null != companyDOS && i < companyDOS.size() ; i++) {
			Map<String, Object> map = new HashMap<>();
            SysCompanyDO sysCompanyDO = companyDOS.get(i);
            map.put("title",sysCompanyDO.getOrgName());
            map.put("key",sysCompanyDO.getOrgId());
            map.put("orgName",sysCompanyDO.getOrgName());
            map.put("orgId",sysCompanyDO.getOrgId());
            map.put("children",new ArrayList<Map>());
            map.put("hasVehicleInfo",false);
            map.put("leaf",true);
            map.put("pId",sysCompanyDO.getpId());
            mapList.add(map);
        }


        return mapList;

	}



	public List<SysCompanyVO> searchList(SysCompanyVO condition) {

		List<SysCompanyVO> vos = new ArrayList<>();
		List<SysCompanyDO> companyDOS = sysCompanyMapper.searchList(condition);
		for (SysCompanyDO companyDO : companyDOS) {
			SysCompanyVO sysCompanyVO = new SysCompanyVO();
			BeanUtils.copyProperties(companyDO,sysCompanyVO);
			vos.add(sysCompanyVO);
		}
		return vos;
	}
}
