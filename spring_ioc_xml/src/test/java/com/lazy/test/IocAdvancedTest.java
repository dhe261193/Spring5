package com.lazy.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazy.entity.Friend;
import com.lazy.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/9 22:17
* @Description: IOC xml配置 进阶版
*/
public class IocAdvancedTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public void before() {
        //创建spring上下文，加载所有的bean
        ioc = new ClassPathXmlApplicationContext("spring_ioc_advanced.xml");

    }

    /*
    * @Description: user对象依赖于friend对象，需要先加载friend
    */
    @Test
    public void testDependsOn() {
        System.out.println("Spring容器已加载");
        User user = ioc.getBean("user", User.class);
        System.out.println(user);
        Friend friend = ioc.getBean("friend",Friend.class);
        System.out.println(friend);
    }

    /*
    * @Description: 真正使用的时候加载bean
    */
    @Test
    public void testLazy() {
        System.out.println("Spring容器已加载");
        Friend friend = ioc.getBean("lazy",Friend.class);
        System.out.println(friend);
    }

    /*
    * @Description: 当scope设置为多例时，每获取一次加载一次
    * 默认只会加载一次
    */
    @Test
    public void testScope() {
        User user1 = ioc.getBean("userS", User.class);
        User user2 = ioc.getBean("userS", User.class);
        User user3 = ioc.getBean("userS", User.class);
    }

    /*
    * @Description: 使用静态工厂注入bean，干预实例化过程
    */
    @Test
    public void testStatic() {
        User userStatic = ioc.getBean("userStatic", User.class);
        System.out.println(userStatic);
    }

    /*
     * @Description: 使用动态工厂注入bean，干预实例化过程
     */
    @Test
    public void testFactory() {
        User userFactory = ioc.getBean("userFactory", User.class);
        System.out.println(userFactory);
    }

    /*
     * @Description: 根据类型自动注入
     */
    @Test
    public void testByType() {
        User userType = ioc.getBean("userType", User.class);
        System.out.println(userType);
    }

    /*
     * @Description: 根据set方法名字自动注入
     */
    @Test
    public void testByName() {
        User userName = ioc.getBean("userName", User.class);
        System.out.println(userName);
    }

    /*
     * @Description: 根据构造函数自动注入
     */
    @Test
    public void testConstructor() {
        User userConstructor = ioc.getBean("userConstructor", User.class);
        System.out.println(userConstructor);
    }

    /*
     * @Description: 生命周期回调
     * 1.使用接口方式实现  实现InitializingBean DisposableBean接口
     * 2.基于配置实现
     */
    @Test
    public void testImplements() {
        User implUser = ioc.getBean("implUser", User.class);
        System.out.println(implUser);
        ioc.close();
    }

    @Test
    public void testLife() {
        User userLife = ioc.getBean("userLife", User.class);
        System.out.println(userLife);
        ioc.close();
    }

    /*
    * @Description: 第三方bean注入
    */
    @Test
    public void testDruid() throws SQLException {
        DruidDataSource dataSource = ioc.getBean("dataSource",DruidDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }
}
