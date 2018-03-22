package com.dygstudio.epsms.api;

import com.dygstudio.epsms.entity.Users;
import com.dygstudio.epsms.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/03/09 上午11:13
 * @description: com.dygstudio.epsms.api
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping("/save")
    public Users save(String name,String address,Integer age){
        return usersService.save(name,address,age);
    }

    @RequestMapping("/findByAddress")
    public List<Users> findByAddress(String address){
        return usersService.getUsersByAddress(address);
    }

    @RequestMapping("/findByNameAndAddress")
    public Users findByNameAndAddress(String name,String address){
        return usersService.getUsersByNameAndAddress(name,address);
    }

    @RequestMapping("/findByQuery")
    public Users findByQuery(String name,String address){
        return usersService.getUsersByQuery(name,address);
    }

    @RequestMapping("/findByNamedQuery")
    public Users findByNamedQuery(String name,String address){
        return usersService.getUsersByNameedQuery(name,address);
    }

    @RequestMapping("/sort")
    public List<Users> sort(){
        return usersService.sort();
    }

    @RequestMapping("/page")
    public Page<Users> page(){
        return usersService.page();
    }

    @RequestMapping("/cache")
    public Users findByNameForCache(String name){
        return usersService.getUsersByName(name);
    }
}
