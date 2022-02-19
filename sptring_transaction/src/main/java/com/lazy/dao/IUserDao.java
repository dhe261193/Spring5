package com.lazy.dao;

import com.lazy.entity.User;

import java.math.BigDecimal;

public interface IUserDao {

    User getUserById (Integer id);

    void addUser (User user);

    void updUser (User user);

    void delUserById (Integer id);

    void addBal(Integer addId, BigDecimal tranBal);

    void subBal(Integer subId, BigDecimal tranBal);
}
