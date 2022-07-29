package cn.ray.design.impl;

import cn.ray.design.CacheService;
import cn.ray.design.RedisUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author JOJO
 * @date 2022/7/29 21:33
 */
public class CacheServiceImpl implements CacheService {
    private RedisUtil redisUtil = new RedisUtil();

    public String get(String key) {
        return redisUtil.get(key);
    }

    public void set(String key, String value) {
        redisUtil.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtil.set(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        redisUtil.del(key);
    }
}
