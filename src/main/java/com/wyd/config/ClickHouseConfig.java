package com.wyd.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ClickHouseConfig {
    @Value("${spring.datasource.clickhouse.address}")
    private  String clickhouseAddress;
    @Value("${spring.datasource.clickhouse.username:222}")
    private  String clickhouseUsername;
    @Value("${spring.datasource.clickhouse.password}")
    private  String clickhousePassword;
    @Value("${spring.datasource.clickhouse.db}")
    private  String clickhouseDB;
    @Value("${spring.datasource.clickhouse.socketTimeout}")
    private  Integer clickhouseSocketTimeout;

    public  Connection getConn() {

        ClickHouseConnection conn = null;
        ClickHouseProperties properties = new ClickHouseProperties();
       properties.setUser("default");
        //properties.setPassword(clickhousePassword);
        properties.setDatabase("default");
        properties.setSocketTimeout(600000);
        ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource("jdbc:clickhouse://192.168.252.250:8123", properties);


        try {
            conn = clickHouseDataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public  List<Map<String, String>> exeSql(String sql) {
        log.info("cliockhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String, String>> list = new ArrayList<>();
            while (results.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
