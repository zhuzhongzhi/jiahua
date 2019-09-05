package com.xgit.iot.infra.constants;


public interface SysConstants {


    /**
     * 机构顶级节点
     */
    public static final String ORG_TOP_ID  = "-1";

    /**
     * 车辆在线状态0离线1在线
     */
    public static final String ONLINE_OUT = "0";
    public static final String ONLINE_ON  = "1";

    public static final String ONLINE_OUT_NAME = "离线";
    public static final String ONLINE_ON_NAME  = "在线";

    /**
     * 车辆工作状态0闲置,1工作
     */
    public static final String WORKSTATUS_OUT  = "0";
    public static final String WORKSTATUS_ON  = "1";
    public static final String WORKSTATUS_WAIT  = "2";

    public static final String WORKSTATUS_OUT_NAME  = "闲置";
    public static final String WORKSTATUS_ON_NAME  = "怠速";
    public static final String WORKSTATUS_WAIT_NAME  = "工作";

    /**
     * 车辆维修状态(0正常,1维修)
     */
    public static final String REPAIR_OUT  = "0";
    public static final String REPAIR_ON  = "1";

    public static final String REPAIR_OUT_NAME  = "正常";
    public static final String REPAIR_ON_NAME  = "维修";

    public static final String ALARM_TYPE_1  = "超速";
    public static final String ALARM_TYPE_2  = "怠速";
    public static final String ALARM_TYPE_3  = "围栏";
    public static final String ALARM_TYPE_4  = "路线";
    public static final String ALARM_TYPE_11  = "终端";

    //大屏所用信息组织机构id
    public static final String ORG_NAME_1  = "运输一队";
    public static final String ORG_NAME_2  = "运输三队";
    public static final String ORG_NAME_3  = "运输四队";
    public static final String ORG_NAME_4  = "九江分公司";
    public static final String ORG_NAME_5  = "南昌分公司";

    public static final String ORG_ID_1  = "100004";
    public static final String ORG_ID_2  = "100006";
    public static final String ORG_ID_3  = "100007";
    public static final String ORG_ID_4  = "100009";
    public static final String ORG_ID_5  = "100011";
    public static final String ORG_ID_6  = "all";

    public static final String WORKNAME  = "工作";
    public static final String NOWORKNAME  = "闲置";
    public static final String REPAIR  = "维修";

    //mm   dd
    public static final String ScreenByType  = "dd";

}
