package test;

import com.lazy.bean.MysqlUser;
import com.lazy.bean.Role;
import com.lazy.bean.User;
import com.lazy.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

    ClassPathXmlApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring_ioc_anno.xml");
    }

    @Test
    public void testUser() {
        User bean = applicationContext.getBean(User.class);
        System.out.println("user name : " + bean.getName());
    }

    @Test
    public void testMysqlUser() {
        MysqlUser bean = applicationContext.getBean(MysqlUser.class);
        System.out.println("mysql  JDBCname : " + bean.getName());
        System.out.println("mysql  password : " + bean.getPassword());
        System.out.println("mysql  url : " + bean.getUrl());
        System.out.println("mysql  driverClassName : " + bean.getDriverClassName());
    }

    @Test
    public void testAutowired() {
        UserController bean = applicationContext.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void testDependsOn() {
        Role role = applicationContext.getBean(Role.class);
        User user = applicationContext.getBean(User.class);
        System.out.println("user name : " + user.getName() + "   role name : " + role.getName());
    }

    @Test
    public void testLazy() {
        System.out.println("Spring 已加载...");
        Role role = applicationContext.getBean(Role.class);
        System.out.println("role name : " + role.getName());
    }

    @Test
    public void testScope() {
        User user1 = applicationContext.getBean(User.class);
        User user2 = applicationContext.getBean(User.class);
        User user3 = applicationContext.getBean(User.class);
    }

    @Test
    public void testLife() {
        User user = applicationContext.getBean(User.class);
        System.out.println("user name : " + user.getName());
        applicationContext.close();
    }
}
