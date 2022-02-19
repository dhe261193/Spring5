package com.lazy.controller;

import com.lazy.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    /*
    * 使用@Autowired实现自动注入
    * 默认优先根据类型（ByType）去匹配
    * 匹配到多个类型会根据名字（ByName）匹配，这个名字指的是bean的名字
    * 如果名字也没匹配到会报错：
    *       1、可以修改属性的名字（userService）改为对应bean的名字（userServiceImpl）
    *       2、可以修改bean的名字对应注解属性的名字  @Service(value="userService")
    *       3、可以为属性添加@Qualifier设置属性名字覆盖  @Qualifier("userServiceImpl")
    *       4、为对应bean添加@Primary注解 设置为主要自动注入bean
    *       5、使用泛型最为自动注入限定符
    */
    //@Autowired
    //@Qualifier("userServiceImpl")
    /*
    * @Resource和@Autowired一样可以实现自动注入
    * 区别：
    *   1、@Autowired是Spring提供的注解；@Resource是JDK定义的注解，依靠JDK的标准
    *   2、@Autowired默认按照类型匹配，默认情况要求依赖的对象必须存在；@Resource默认按照名字匹配，同时可以指定name属性
    *   3、@Autowired只适合Spring框架；@Resource扩展性更好
    */
    @Resource
    UserService userService;

    public void getUser() {
        userService.getUser();
    }
}
