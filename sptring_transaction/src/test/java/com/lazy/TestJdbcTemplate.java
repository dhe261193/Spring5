package com.lazy;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazy.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestJdbcTemplate {

    ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring_jdbc.xml");
    }

    @Test
    public void testDruid() {
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    /**
    * @Description: 查询单个值
    */
    @Test
    public void testSingle() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        Long count = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        System.out.println("-----  t_user表 有" + count + "条数据");
    }

    /**
     * @Description: 查询实体类
     * 如果实体类属性名和表字段名一致 使用BeanPropertyRowMapper自动映射
     * 不一致，使用new RowMapper 使用resultSet填充对象。转为lambda表达式如下user2
     */
    @Test
    public void testEntity() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        User user1 = jdbcTemplate.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));
        System.out.println(user1);
        User user2 = jdbcTemplate.queryForObject("select * from t_user where id=2",
                ((resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setAge(resultSet.getInt("age"));
                    user.setGender(resultSet.getString("gender"));
                    return user;
                }));
        System.out.println(user2);
    }

    /**
    * @Description: 插入
    */
    @Test
    public void testInsert() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int update = jdbcTemplate.update("insert into t_user(name,age,gender) values (?,?,?)", "小学徒", 20, "男");
        System.out.println(update);
    }

    /**
     * @Description: 修改
     */
    @Test
    public void testUpdate() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int update = jdbcTemplate.update("update t_user set age=? where id=?", 30, 5);
        System.out.println(update);
    }

    /**
     * @Description: 删除
     */
    @Test
    public void testDelete() {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int update = jdbcTemplate.update("delete from t_user where id=?", 5);
        System.out.println(update);
    }

    /**
     * @Description: 使用具名函数jdbcTemplate，参数用map传入
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        User user = namedParameterJdbcTemplate.queryForObject("select * from t_user where id=:id", map, new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
}
