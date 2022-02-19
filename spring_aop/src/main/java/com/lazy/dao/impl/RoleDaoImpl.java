package com.lazy.dao.impl;

import com.lazy.bean.Role;
import com.lazy.dao.RoleDao;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Override
    public Role get(String name) {

        return new Role();
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void add(Role role) {

    }

    @Override
    public void delete(Integer id) {

    }
}
