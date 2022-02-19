package com.lazy.service;

import com.lazy.entity.Child;
import com.lazy.entity.User;

public class UserService {

    public User createUserInstance() {
        Child child = new Child();
        child.setName("HaHa2");
        child.setAge(7);
        return child;
    }
}
