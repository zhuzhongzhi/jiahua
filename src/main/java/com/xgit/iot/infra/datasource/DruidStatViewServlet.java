package com.xgit.iot.infra.datasource;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author wanghao
 * @Description 提供druid监控页面的servlet
 * @date 2018-03-06 14:25
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*", initParams = {
//		@WebInitParam(name = "allow", value = "127.0.0.1"), // IP白名单
//        @WebInitParam(name = "deny", value = "192.168.1.149"), // IP黑名单
        @WebInitParam(name = "loginUsername", value = "admin"), // 用户名
        @WebInitParam(name = "loginPassword", value = "123456"), // 密码
        @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset
        // All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
