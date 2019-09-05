package com.xgit.iot.infra.enums;

/**
 * 1：本地、2：其他服务器、3：第三方服务
 * @author chenjunfei
 * @email chenjunfei@bkrwin.com
 * @date 2018-11-26
 */
public enum FileStorageEngine {
    /**
     * 0：本地
     */
    LOCAL,
    /**
     * 1：从服务器—图片服务器
     */
    SLAVE,
    /**
     * 2：第三方服务
     */
    THRID_SERVICE,
    ;

}
