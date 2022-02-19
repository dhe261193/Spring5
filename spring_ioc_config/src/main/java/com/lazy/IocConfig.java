package com.lazy;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazy.bean.MyImportBeanDefinitionRegistrar;
import com.lazy.bean.User;
import org.springframework.beans.factory.annotation.Value;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/15 15:15
* @Description:  代替xml文件
*/
//用于标记一个spring的配置类，代替xml启动spring上下文  相当于xml文件 <bean>
@Configuration
//相当于<context:component-scan base-package="com.lazy"/>
@ComponentScan(basePackages = "com.lazy")
//引入外部属性资源文件
@PropertySource("classpath:db.properties")
//在主配置类中引入其他配置类
//@Import(OtherConfig.class)
//将类注册为bean，通过类型获取
//@Import(User.class)
//实现ImportSelector接口，通过字符串数组注册多个bean
//@Import(MyImportSelector.class)
//实现ImportBeanDefinitionRegistrar，可以注册多个beanDefinition
@Import(MyImportBeanDefinitionRegistrar.class)
public class IocConfig {

    @Value("${jdbc.username}")
    private String name;

    @Value("${password}")
    private String password;

    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverClassName;

    /**
    * 将一个实例注册为一个bean，会自动的将返回值设置为bean的类型，方法名为bean的名字
     * @Bean(name = {"datasource","mysql"}) 设置bean的名字 ，别名
     * @Bean(initMethod = "init", destroyMethod = "")  初始化和销毁
    */
    //@Bean(name = {"datasource","mysql"})
    @Bean
    public DruidDataSource dataSource(User user) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(name);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        //System.out.println("datasource method - User name: " + user.getName());
        //System.out.println("internal bean -- User2: " + user2());
        return dataSource;
    }

    /*@Bean
    public User user2(){
        return new User();
    }*/
}
