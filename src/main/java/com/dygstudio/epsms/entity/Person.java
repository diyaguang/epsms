package com.dygstudio.epsms.entity;

/**
 * @author: diyaguang
 * @date: 2018/03/06 下午2:09
 * @description: com.dygstudio.epsms.entity
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
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
}
