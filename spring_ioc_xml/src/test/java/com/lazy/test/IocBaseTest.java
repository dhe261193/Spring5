package com.lazy.test;

import com.lazy.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/9 22:15
* @Description: IOC Xml配置基础
*/
public class IocBaseTest {

    ApplicationContext ioc;
    @Before
    public void before() {
        //创建spring上下文，加载所有的bean
        //ClassPathXmlApplicationContext 根据项目路径的xml配置实例化spring容器
        //FileSystemXmlApplicationContext  根据磁盘路径的xml配置实例化spring容器
        //AnnotationConfigApplicationContext 根据javaConfig配置实例化spring容器
        //在容器实例化的时候就会加载所有bean
        ioc = new ClassPathXmlApplicationContext("spring_ioc_base.xml");
        System.out.println("Spring容器已加载");
    }

    /*
    * @Description: 获取bean的方法
    */
    @Test
    public void testBean() {

        //1.通过类获取bean
        //User user = ioc.getBean(User.class);
        //2.通过bean的名字或id获取bean
        //User user1 = (User) ioc.getBean("user");
        //3.通过名字+类型获取bean
        //User user = ioc.getBean("user", User.class);
        //4.通过别名获取bean
        User user = ioc.getBean("lazy", User.class);
        System.out.println(user);
    }

    /*
    * @Description: 基于setter方法注入bean对象
    */
    @Test
    public void testSetter() {
        User userSet = ioc.getBean("userSet",User.class);
        System.out.println(userSet);
    }

    /*
     * @Description: 基于构造函数注入bean对象
     */
    @Test
    public void testConstructor() {
        User userCst = ioc.getBean("userCst",User.class);
        System.out.println(userCst);
    }

    /*
     * @Description: 复杂数据类型注入
     */
    @Test
    public void testComplex () {
        User userComplex = ioc.getBean("userComplex",User.class);
        System.out.println(userComplex);
    }

    /*
     * @Description: P命名空间简化setter注入，但是不支持集合
     * xmlns:P="http://www.springframework.org/schema/p"
     */
    @Test
    public void testP() {
        User userP = ioc.getBean("userP",User.class);
        System.out.println(userP);
    }

    /*
     * @Description: C命名空间 简化基于构造函数的使用，不支持集合
     * xmlns:C="http://www.springframework.org/schema/c"
     */
    @Test
    public void testC() {
        User userC = ioc.getBean("userC",User.class);
        System.out.println(userC);
    }
}
