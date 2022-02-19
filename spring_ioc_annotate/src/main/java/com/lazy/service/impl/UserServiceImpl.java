package com.lazy.service.impl;

import com.lazy.dao.UserDao;
import com.lazy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
