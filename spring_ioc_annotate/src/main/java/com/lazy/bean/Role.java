package com.lazy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@DependsOn("user")
//@Scope(value = "prototype")
@Lazy
public class Role {

    @Value("develop")
    private String name;

    public Role () {
        System.out.println("role 已加载....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
