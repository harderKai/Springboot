package com.lukai.firstboot.pojo;
//这是mybatis创建实体类的格式，不需要任何的注解，而是放在mapper那里注解
public class User_info {
    private  int id;
    private String name;
    private int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
