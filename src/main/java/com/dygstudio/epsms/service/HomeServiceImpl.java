package com.dygstudio.epsms.service;

import com.dygstudio.epsms.common.Action;
import org.springframework.stereotype.Service;

/**
 * @author: diyaguang
 * @date: 2018/02/28 上午9:52
 * @description: com.dygstudio.epsms.service
 */
@Service
public class HomeServiceImpl implements HomeService {

    //@Action(name = "注解式的拦截的 操作 ")
    public boolean Login(String userName,String password){
        return true;
    }
}
