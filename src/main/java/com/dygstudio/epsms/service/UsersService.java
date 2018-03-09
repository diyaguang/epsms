package com.dygstudio.epsms.service;

import com.dygstudio.epsms.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/03/09 上午9:42
 * @description: com.dygstudio.epsms.service
 */
@Service
public interface UsersService {
    Users save(String name,String address,Integer age);
    List<Users> getAll();
    List<Users> getUsersByAddress(String address);
    Users getUsersByNameAndAddress(String name,String address);
    Users getUsersByQuery(String name,String address);
    Users getUsersByNameedQuery(String name,String address);
    List<Users> sort();
    Page<Users> page();
}
