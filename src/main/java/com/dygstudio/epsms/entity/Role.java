package com.dygstudio.epsms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: diyaguang
 * @date: 2018/03/13 下午5:32
 * @description: com.dygstudio.epsms.entity
 */
@Entity
public class Role {

    @Id
    private String id;
    private String name;

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
}
