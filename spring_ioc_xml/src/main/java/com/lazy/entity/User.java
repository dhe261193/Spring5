package com.lazy.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/9 20:36
* @Description: Spring IOC xml配置学习
*/
public class User implements InitializingBean, DisposableBean {

    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String job;
    private List<String> hobby;
    private List<Friend> friends;

    public User() {
        System.out.println("User已加载");
    }

    public User(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public User(List<Friend> friends) {
        this.friends = friends;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", hobby=" + hobby +
                ", friends=" + friends +
                '}';
    }

    /*
    * @Description: 静态工厂
    */
    public static User createUserFactory(){
        Child child = new Child();
        child.setName("HaHa");
        child.setAge(5);
        return child;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //System.out.println("实例化user1");
    }

    @Override
    public void destroy() throws Exception {
        //System.out.println("销毁user1");
    }

    public void initByConfig() throws Exception {
        System.out.println("实例化user2");
    }

    public void destroyByConfig() throws Exception {
        System.out.println("销毁user2");
    }
}
