package com.lazy.dao.impl;

import com.lazy.bean.User;
import com.lazy.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User get(String name) {
        return new User();
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
