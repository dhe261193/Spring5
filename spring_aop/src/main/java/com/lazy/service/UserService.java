package com.lazy.service;

import com.lazy.bean.User;

public interface UserService {

    User get (String name);

    void update (Integer id);

    void add (User user);

    void delete (Integer id);
}
