package com.lazy.bean;

import org.springframework.beans.factory.annotation.Value;

public class Wife {

    @Value("小黑")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                '}';
    }
}
