package com.dygstudio.epsms.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: diyaguang
 * @date: 2018/03/21 下午4:50
 * @description: com.dygstudio.epsms.repository
 */
@Repository
public class RedisRepository {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public <T> void add(String key ,Long time,T t){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(t),time, TimeUnit.MINUTES);
    }
    public <T> void add(String key, Long time, List<T> objs){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(objs),time, TimeUnit.MINUTES);
    }
    public <T> T get(String key,Class<T> tClass){
        Gson gson = new Gson();
        T obj = null;
        String tJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isNullOrEmpty(tJson)){
            obj = gson.fromJson(tJson, tClass);
        }
        return obj;
    }
    public <T> List<T> getList(String key,Class<T> tClass){
        Gson gson = new Gson();
        List<T> ts = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isNullOrEmpty(listJson)) {
            ts = gson.fromJson(listJson,new TypeToken<List<T>>(){}.getType());
        }
        return ts;
    }
    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}