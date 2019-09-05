package com.xgit.iot.service.vo.system;

import java.util.Date;

/**
 * Created by GYJ on 2017-12-27.
 */
public class DictionaryRelationVO {
    private String id;
    private String pId;

    //编码
    private String code;
    //父编码
    private String parentCode;
    //所属组
    private String groupName;
    //名称
    private String name;
    //父名称
    private String parentName;
    //是否有效
    private Short valid;
    //是否私有（是否可修改）
    private Short privated;
    //备注
    private String remark;

    private Date createDate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
    }

    public Short getPrivated() {
        return privated;
    }

    public void setPrivated(Short privated) {
        this.privated = privated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
