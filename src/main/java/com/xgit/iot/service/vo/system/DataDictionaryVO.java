package com.xgit.iot.service.vo.system;

import java.util.Date;

/**
 * Created by GYJ on 2017-12-27.
 */
public class DataDictionaryVO {

    private String id;
    private String pId;
    //编码
    private String code;
    //所属组
    private String groupName;
    //名称
    private String name;
    //是否有效
    private Short valid;
    //是否私有（是否可修改）
    private Short privated;
    //备注
    private String remark;

    private String createId;

    private Date createDate;

    private String updateId;

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

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
}
