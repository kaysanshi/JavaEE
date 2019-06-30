package com.kayleoi.hellospringboot.bean;

import java.io.Serializable;

/**
 * @Author kay三石
 * @date:2019/5/20
 */
public class PersonBean implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
