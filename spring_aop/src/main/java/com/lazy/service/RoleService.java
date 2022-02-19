package com.lazy.service;

import com.lazy.bean.Role;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/18 21:34
* @Description:
*/
public interface RoleService {

    Role get (String name);

    void update (Integer id);

    void add (Role role);

    void delete (Integer id);
}
