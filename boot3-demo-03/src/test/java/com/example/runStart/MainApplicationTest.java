package com.example.runStart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
// 如果不在com.example包下，则需要指定启动类，因为启动类默认扫描com.example包及其子包，违反默认扫描规则
//@SpringBootTest(classes = MainApplicationTest.class)
//@AutoConfigureJdbc
public class MainApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testDatabaseConnection() {
        // 执行一个简单的查询来测试数据库连接
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        assertNotNull(result, "Database connection failed");
    }
}
