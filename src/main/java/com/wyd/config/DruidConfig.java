package com.wyd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DruidConfig {
    @Resource
    private JdbcParamConfig jdbcParamConfig;

    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:clickhouse://192.168.252.250:8123");
        datasource.setDriverClassName("ru.yandex.clickhouse.ClickHouseDriver");
        datasource.setInitialSize(10);
        datasource.setMinIdle(10);
        datasource.setMaxActive(100);
        datasource.setMaxWait(6000);
        return datasource;
    }
}