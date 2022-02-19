package com.lazy.service.impl;

import com.lazy.dao.IUserDao;
import com.lazy.entity.User;
import com.lazy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updUser(User user) {
        userDao.updUser(user);
    }

    @Override
    public void delUserById(Integer id) {
        userDao.delUserById(id);
    }
    
    /**
    * @Description: 转账
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void tran(Integer addId, Integer subId, BigDecimal tranBal) {
        addBal(addId, tranBal);
        subBal(subId, tranBal);
    }

    /**
     * @Description: 加钱
     */
    public void addBal(Integer addId, BigDecimal tranBal) {
        userDao.addBal(addId, tranBal);
    }

    /**
     * @Description: 扣钱
     */
    public void subBal(Integer subId, BigDecimal tranBal) {
        userDao.subBal(subId, tranBal);
    }
}
