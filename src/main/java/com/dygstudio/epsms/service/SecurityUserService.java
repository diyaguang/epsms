package com.dygstudio.epsms.service;

import com.dygstudio.epsms.entity.Users;
import com.dygstudio.epsms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author: diyaguang
 * @date: 2018/03/13 下午7:59
 * @description: com.dygstudio.epsms.service
 */
//自定义需要实现 UserDetailsService接口
public class SecurityUserService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override   //重写 loadUserByUsernae 方法获得用户
    public UserDetails loadUserByUsername(String username){
        Users user = usersRepository.findByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //我们当前的用户实现了 UserDetails 接口，可直接返回给 Spring Security 使用
        return user;
    }
}
