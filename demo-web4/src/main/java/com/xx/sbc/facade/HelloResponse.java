package com.xx.sbc.facade;

import java.io.Serializable;

/**
 * Created by jiyiqin on 2019/6/29.
 */
public class HelloResponse implements Serializable {
    private String name;
    private Integer age;

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
}
