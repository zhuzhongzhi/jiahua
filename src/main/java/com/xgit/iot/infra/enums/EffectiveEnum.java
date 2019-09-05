package com.xgit.iot.infra.enums;

/**
 * 是否生效
 *
 * @author hz
 * @version 1.0.0
 * @createTime: 2018/12/7 16:24
 */
public enum EffectiveEnum {
    YES(1, "是"),
    NO(0, "否"),;

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    EffectiveEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
