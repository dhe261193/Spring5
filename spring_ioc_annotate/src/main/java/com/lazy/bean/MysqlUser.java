package com.lazy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/15 12:08
* @Description:
*/
@Component
public class MysqlUser {

    @Value("${jdbc.username}")
    private String name;

    @Value("${password}")
    private String password;

    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverClassName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
