package com.xgit.iot.infra.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public Map<Object, Object> getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public Object getHSetValue(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 保存验证码
     */
    public void setWithSec(String key, String value, Integer seconds) {
        if (seconds != null && seconds > 0) {
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
            return;
        }

        redisTemplate.opsForValue().set(key, value);
    }


    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
