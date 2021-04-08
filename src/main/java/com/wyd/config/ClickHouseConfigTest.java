package com.wyd.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ClickHouseConfigTest {

    @Autowired
    ClickHouseConfig clickHouseConfig;
    @Test
    public void exeSql() {
        log.info("===========测试开始============");
        String sql = "select * from tb_user;";
        System.out.println(ClickHouseConfig.class);
        List<Map<String, String>> result = clickHouseConfig.exeSql(sql);
        log.info("===========查询技术============");
        log.info("clickhouse查询结果为：{}", result);
    }
}
