package com.lazy.dao;

import com.lazy.bean.Role;

public interface RoleDao {

    Role get (String name);

    void update (Integer id);

    void add (Role role);

    void delete (Integer id);
}
