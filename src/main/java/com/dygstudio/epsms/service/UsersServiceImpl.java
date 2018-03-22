package com.dygstudio.epsms.service;

import com.dygstudio.epsms.common.CommonUtil;
import com.dygstudio.epsms.entity.Users;
import com.dygstudio.epsms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/03/09 上午10:27
 * @description: com.dygstudio.epsms.service
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users save(String name, String address, Integer age){
        Users u = usersRepository.save(new Users(CommonUtil.getNewGuid(true),name,age,address));
        return u;
    }
    public List<Users> getAll(){
        return usersRepository.findAll();
    }
    public List<Users> getUsersByAddress(String address){
        return usersRepository.findByAddress(address);
    }
    public Users getUsersByNameAndAddress(String name,String address){
        return usersRepository.findByNameAndAddress(name,address);
    }
    public Users getUsersByQuery(String name,String address){
        return usersRepository.withNameAndAddressQuery(name,address);
    }
    public Users  getUsersByNameedQuery(String name,String address){
        return usersRepository.withNameAndAddressNamedQuery(name,address);
    }
    public List<Users> sort(){
        return usersRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
    }
    public Page<Users> page(){
        return usersRepository.findAll(new PageRequest(1,2));
    }

    @Cacheable(value = "dygxxxx",key = "#name")
    public Users getUsersByName(String name){
        return usersRepository.findByName(name);
    }
}
