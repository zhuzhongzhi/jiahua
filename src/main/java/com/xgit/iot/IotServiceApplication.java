package com.xgit.iot;

import com.bkrwin.ufast.annotation.EnableGenServiceClient;
import com.bkrwin.ufast.infra.annotation.EnableFastAccessGrant;
import com.bkrwin.ufast.infra.infra.eureka.EurekaDeregister;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Properties;


/**
 * 类注释
 *
 * @author: hz
 * @date: 2019/03/08
 * @since: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.bkrwin.ufast"})
@EnableFastAccessGrant
@EnableGenServiceClient
public class IotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotServiceApplication.class, args);
	}

	/**
	 * 停止服务时注销掉在eureka上的信息
	 * @param registration
	 * @param serviceRegistry
	 * @param eurekaClientConfigBean
     * @return
     */
	@Bean(initMethod = "showDeregisterInfo", destroyMethod = "deregister")
	public EurekaDeregister eurekaDeregister(EurekaRegistration registration, EurekaServiceRegistry serviceRegistry, EurekaClientConfigBean eurekaClientConfigBean)
	{
		return new EurekaDeregister(registration, serviceRegistry, eurekaClientConfigBean);
	}

	@Bean
	PageHelper pageHelper(){
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);

		//添加插件
		new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
		return pageHelper;
	}

}
