package com.wyd;

import com.wyd.config.ClickHouseConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;


@SpringBootApplication
@Slf4j
@MapperScan("com.wyd.dao")
public class App {

    public static void main(String[] args) {
      SpringApplication.run(App.class);
       /* System.out.println("Hello World!");
        String sql = "select * from tb_user;";
        System.out.println(ClickHouseConfig.class);
        ClickHouseConfig ClickHouseConfig = new ClickHouseConfig();
        List<Map<String, String>> result =ClickHouseConfig.exeSql(sql);
        log.info("===========查询技术============");
        log.info("clickhouse查询结果为：{}", result);*/
    }
}
