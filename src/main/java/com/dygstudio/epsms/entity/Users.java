package com.dygstudio.epsms.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/03/08 下午5:38
 * @description: com.dygstudio.epsms.entity
 */
@Entity
@NamedQuery(name = "Users.withNameAndAddressNamedQuery",query = "select u from Users u where u.name=?1 and u.address=?2")
public class Users implements UserDetails {   //用户实体实现 UserDetails 接口我们的用户实体即为 Spring Security所使用的用户

    private static final long serialVersionUID = 1l;
    @Id
    private String id;
    private String name;

    private Integer age;
    private String address;
    private String passwordStr;

    public void setPasswordStr(String password) {
        this.passwordStr = password;
    }
    public String getPasswordStr(){return this.passwordStr;}

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

    public Users() {
        super();
    }

    public Users(String id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //配置用户和角色的多对多关系
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    //重写 getAuthorities 方法，将用户的角色作为权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<Role> roles = this.getRoles();
        for (Role role:roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
    @Override
    public String getUsername(){
        return this.getName();
    }
    @Override
    public String getPassword(){
        return this.getPasswordStr();
    }
}