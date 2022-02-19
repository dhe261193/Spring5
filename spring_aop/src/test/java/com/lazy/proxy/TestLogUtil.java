package com.lazy.proxy;

import com.lazy.service.UserService;
import com.lazy.service.impl.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLogUtil {
    ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring_aop.xml");
    }

    @Test
    public void testAspect() {
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
        userService.get("小学徒");
    }

    @Test
    public void testCglibOrJDK() {
        RoleServiceImpl roleService = context.getBean(RoleServiceImpl.class);
        System.out.println(roleService.getClass());

        System.out.println("----------------");

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getClass());
    }
}
