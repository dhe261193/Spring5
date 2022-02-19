package com.lazy;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazy.IocConfig;
import com.lazy.bean.Person;
import com.lazy.bean.User;
import com.lazy.bean.Wife;
import com.lazy.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

    AnnotationConfigApplicationContext context;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(IocConfig.class);
    }

    @Test
    public void testIocConfig() {
        UserController bean = context.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void testDruid() {
        System.out.println("------------------");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testImportUser() {
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }

    @Test
    public void testImportSelector() {
        Person person = context.getBean(Person.class);
        Wife wife = context.getBean(Wife.class);
        System.out.println(person);
        System.out.println(wife);
    }

    @Test
    public void testBeanDefinition() {
        Person person = context.getBean("personBean", Person.class);
        System.out.println(person);
    }
}
