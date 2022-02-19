package com.lazy.service.impl;

import com.lazy.bean.User;
import com.lazy.dao.UserDao;
import com.lazy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(String name) {
        System.out.println("----查询user----");
        return userDao.get(name);
    }

    @Override
    public void update(Integer id) {
        System.out.println("----更改user----");
        userDao.update(id);
    }

    @Override
    public void add(User user) {
        System.out.println("----新增user----");
        userDao.add(user);
    }

    @Override
    public void delete(Integer id) {
        System.out.println("----删除user----");
        userDao.delete(id);
    }
}
