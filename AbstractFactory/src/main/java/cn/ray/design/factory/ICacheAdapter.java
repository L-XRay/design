package cn.ray.design.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author JOJO
 * @date 2022/7/29 22:10
 * 动态代理 委托对象
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
