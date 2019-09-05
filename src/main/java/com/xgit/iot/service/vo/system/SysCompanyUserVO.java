package com.xgit.iot.service.vo.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Accessors(chain = true)
@ApiModel(value = "SysCompanyUser",description = "机构信息表")
public class SysCompanyUserVO {
	/**
	 * 企业编号
	 */
	@TableId(value = "org_id", type = IdType.ID_WORKER)
	@ApiModelProperty(value="企业编号",name="orgId",required = true)
	private String orgId;

	/**
	 * 父机构id
	 */
	@TableField("p_id")
	@ApiModelProperty(value="父机构id",name="pId",required = true)
	private String pId;

	/**
	 * 机构编码
	 */
	@TableField("org_code")
	@ApiModelProperty(value="机构编码",name="orgCode",required = true)
	private String orgCode;

	/**
	 * 企业名称
	 */
	@TableField("org_name")
	@ApiModelProperty(value="企业名称",name="orgName",required = true)
	private String orgName;

	/**
	 * 公司性质id
	 */
	@TableField("org_nature")
	@ApiModelProperty(value="公司性质id",name="orgNature",required = true)
	private String orgNature;

	/**
	 * 公司性质名称
	 */
	@TableField("org_nature_name")
	@ApiModelProperty(value="公司性质名称",name="orgNatureName",required = true)
	private String orgNatureName;

	/**
	 * 外文名称
	 */
	@TableField("eng_name")
	@ApiModelProperty(value="外文名称",name="engName",required = true)
	private String engName;

	/**
	 * 中文名称
	 */
	@TableField("chinese_name")
	@ApiModelProperty(value="中文名称",name="chineseName",required = true)
	private String chineseName;

	/**
	 * 成立时间
	 */
	@TableField("setup_date")
	@ApiModelProperty(value="成立时间",name="setupDate",required = true)
	private Date setupDate;

	/**
	 * 负责人
	 */
	@TableField("principal")
	@ApiModelProperty(value="负责人",name="principal",required = true)
	private String principal;

	/**
	 * 电话
	 */
	@TableField("tel")
	@ApiModelProperty(value="电话",name="tel",required = true)
	private String tel;

	/**
	 * 邮箱
	 */
	@TableField("email")
	@ApiModelProperty(value="邮箱",name="email",required = true)
	private String email;

	/**
	 * 传真
	 */
	@TableField("fax")
	@ApiModelProperty(value="传真",name="fax",required = true)
	private String fax;

	/**
	 * 省主键
	 */
	@TableField("province_id")
	@ApiModelProperty(value="省主键",name="provinceId",required = true)
	private String provinceId;

	/**
	 * 市主键
	 */
	@TableField("city_id")
	@ApiModelProperty(value="市主键",name="cityId",required = true)
	private String cityId;

	/**
	 * 县/区主键
	 */
	@TableField("county_id")
	@ApiModelProperty(value="区主键",name="countyId",required = true)
	private String countyId;

	/**
	 * 详细地址
	 */
	@TableField("address")
	@ApiModelProperty(value="详细地址",name="address",required = true)
	private String address;

	/**
	 * 经度（默认取高德地图）
	 */
	@TableField("lng")
	@ApiModelProperty(value="经度（默认取高德地图）",name="lng",required = true)
	private BigDecimal lng;

	/**
	 * 维度（默认取高德地图）
	 */
	@TableField("lat")
	@ApiModelProperty(value="维度（默认取高德地图）",name="lat",required = true)
	private BigDecimal lat;

	/**
	 * 公司网址
	 */
	@TableField("company_website")
	@ApiModelProperty(value="公司网址",name="companyWebsite",required = true)
	private String companyWebsite;

	/**
	 * 经营范围
	 */
	@TableField("scope_business")
	@ApiModelProperty(value="经营范围",name="scopeBusiness",required = true)
	private String scopeBusiness;

	/**
	 * 备注说明
	 */
	@TableField("remark")
	@ApiModelProperty(value="备注说明",name="remark",required = true)
	private String remark;

	/**
	 * 删除标记(0:未删除 1:已删除)
	 */
	@TableField("deleted")
	@ApiModelProperty(value="删除标记(0:未删除 1:已删除)",name="deleted",required = true)
	private Integer deleted;

	/**
	 * 启用标志(0:未启用 1:已启用)
	 */
	@TableField("enabled")
	@ApiModelProperty(value="启用标志(0:未启用 1:已启用)",name="enabled",required = true)
	private Integer enabled;

	/**
	 * 创建日期
	 */
	@TableField("create_date")
	@ApiModelProperty(value="创建日期",name="createDate",required = true)
	private Date createDate;

	/**
	 * 创建用户主键
	 */
	@TableField("create_user_id")
	@ApiModelProperty(value="创建用户主键",name="createUserId",required = true)
	private String createUserId;

	/**
	 * 创建用户名称
	 */
	@TableField("create_user_name")
	@ApiModelProperty(value="创建用户名称",name="createUserName",required = true)
	private String createUserName;

	/**
	 * 修改日期
	 */
	@TableField("modify_date")
	@ApiModelProperty(value="修改日期",name="modifyDate",required = true)
	private Date modifyDate;

	/**
	 * 修改用户主键
	 */
	@TableField("modify_user_id")
	@ApiModelProperty(value="修改用户主键",name="modifyUserId",required = true)
	private String modifyUserId;

	/**
	 * 修改用户名称
	 */
	@TableField("modify_user_name")
	@ApiModelProperty(value="修改用户名称",name="modifyUserName",required = true)
	private String modifyUserName;



	/**
	 * 登陆名称
	 */
	@ApiModelProperty(value="登陆名称",name="loginName",required = true)
	private String loginName;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value="用户id",name="userId",required = true)
	private String userId;

	/**
	 * 邮编
	 */
	@TableField("zip_code")
	@ApiModelProperty(value="邮编",name="zipCode",required = true)
	private String zipCode;

	/**
	 * 省市县全称
	 */
	@TableField("area_name")
	@ApiModelProperty(value="省市县全称",name="areaName",required = true)
	private String areaName;

	/**
	 * 所属机构
	 */
	@ApiModelProperty(value="所属机构",name="pOrgName",required = true)
	private String pOrgName;


	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgNature() {
		return orgNature;
	}

	public void setOrgNature(String orgNature) {
		this.orgNature = orgNature;
	}

	public String getOrgNatureName() {
		return orgNatureName;
	}

	public void setOrgNatureName(String orgNatureName) {
		this.orgNatureName = orgNatureName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public Date getSetupDate() {
		return setupDate;
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getScopeBusiness() {
		return scopeBusiness;
	}

	public void setScopeBusiness(String scopeBusiness) {
		this.scopeBusiness = scopeBusiness;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getpOrgName() {
		return pOrgName;
	}

	public void setpOrgName(String pOrgName) {
		this.pOrgName = pOrgName;
	}
}
