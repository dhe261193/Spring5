package com.lazy.service;

import com.lazy.entity.User;

import java.math.BigDecimal;

public interface IUserService {

    User getUserById (Integer id);

    void addUser (User user);

    void updUser (User user);

    void delUserById (Integer id);

    void tran(Integer addId, Integer subId, BigDecimal tranBal);
}
