package com.lazy.service.impl;

import com.lazy.bean.Role;
import com.lazy.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

    //@Override
    public Role get(String name) {
        System.out.println("----查询Role----");
        return roleDao.get(name);
    }

    //@Override
    public void update(Integer id) {
        System.out.println("----更改user----");
        roleDao.update(id);
    }

    //@Override
    public void add(Role role) {
        System.out.println("----新增role----");
        roleDao.add(role);
    }

    //@Override
    public void delete(Integer id) {
        System.out.println("----删除role----");
        roleDao.delete(id);
    }
}
