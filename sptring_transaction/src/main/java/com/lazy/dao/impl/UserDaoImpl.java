package com.lazy.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazy.dao.IUserDao;
import com.lazy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class UserDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DruidDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserById(Integer id) {
        return jdbcTemplate.queryForObject("select * from t_user where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updUser(User user) {

    }

    @Override
    public void delUserById(Integer id) {

    }

    @Override
    public void addBal(Integer addId, BigDecimal tranBal) {
        jdbcTemplate.update("update t_user set balance=balance+? where id=?", tranBal, addId);
    }

    @Override
    public void subBal(Integer subId, BigDecimal tranBal) {
        jdbcTemplate.update("update t_user set balance=balance-? where id=?", tranBal, subId);
    }
}
