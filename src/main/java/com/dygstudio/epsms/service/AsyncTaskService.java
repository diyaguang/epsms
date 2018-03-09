package com.dygstudio.epsms.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: diyaguang
 * @date: 2018/02/28 下午5:56
 * @description: com.dygstudio.epsms.service
 * 对于这个定义好的 异步执行的任务，直接执行就可以了
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务:"+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:"+(i+1));
    }
}
