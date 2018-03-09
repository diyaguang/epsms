package com.dygstudio.epsms.service;

import com.dygstudio.epsms.common.Action;
import org.springframework.stereotype.Service;

/**
 * @author: diyaguang
 * @date: 2018/02/28 上午9:51
 * @description: com.dygstudio.epsms.service
 */
@Service
public interface HomeService {
    @Action(name = "注解式的拦截的 操作 ")
    boolean Login(String userName,String password);
}
