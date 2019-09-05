package com.xgit.iot.infra.constants;


public interface Constants {

    /**
     * sql日期格式常量
     */

    interface SqlDateType {
        /**
         * 年月日
         */
        String DAY_TYPE = "%Y-%m-%d";

        /**
         * 年月
         */
        String MONTH_TYPE = "%Y-%m";

        /**
         * 年
         */
        String YEAR_TYPE = "%Y";
    }

    /**
     * 序列号类型
     */
    interface SequenceType {
        /**
         * 生成企业OrgId类型
         */
        int COMPANY = 1;
    }

    /**
     * 平台
     */
    interface Site {
        /**
         * 运维平台
         */
        int Operational = 0;

        /**
         * 设备监控平台
         */
        int Machine_Monitor = 1;
    }

    /**
     * 入驻的公司统一使用的模板编号
     */
    String Company_Template = "2";

    /**
     * 新增公司默认管理员密码
     */
    String Default_Password = "123456";

}
