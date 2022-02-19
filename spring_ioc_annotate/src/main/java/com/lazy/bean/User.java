package com.lazy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class User {

    /*
    * 使用@Value注解设置依赖注入的属性
    * 1.可以写硬编码值
    * 2.还可以写${} #{}
    */
    @Value("小学徒")
    private String name;

    public User() {
        System.out.println("user 已加载....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("init 初始化....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy 销毁....");
    }

}
