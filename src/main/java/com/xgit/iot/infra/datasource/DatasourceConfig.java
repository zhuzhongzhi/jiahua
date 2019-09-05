package com.xgit.iot.infra.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

import static com.alibaba.druid.pool.DruidDataSourceFactory.*;

/**
 * @author wanghao
 * @Description
 * @date 2018-03-06 14:15
 */
@Configuration
@ServletComponentScan
public class DatasourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put(PROP_DRIVERCLASSNAME, dataSourceProperties.getDriverClassName());
        props.put(PROP_URL, dataSourceProperties.getUrl());
        props.put(PROP_USERNAME, dataSourceProperties.getUsername());
        props.put(PROP_PASSWORD, dataSourceProperties.getPassword());
        props.put(PROP_FILTERS, "stat");
        return DruidDataSourceFactory.createDataSource(props);
    }
}
