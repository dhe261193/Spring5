package com.lazy.dao;

import com.lazy.bean.User;

public interface UserDao {

    User get(String name);

    void update (Integer id);

    void add (User user);

    void delete (Integer id);
}
