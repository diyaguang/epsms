package com.dygstudio.epsms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author: diyaguang
 * @date: 2018/03/08 下午5:38
 * @description: com.dygstudio.epsms.entity
 */
@Entity
@NamedQuery(name = "Users.withNameAndAddressNamedQuery",query = "select u from Users u where u.name=?1 and u.address=?2")
public class Users {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Users()
    {
        super();
    }
    public Users(String id,String name,Integer age,String address){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
