package cn.ray.design;

import java.util.concurrent.TimeUnit;

/**
 * @author JOJO
 * @date 2022/7/29 21:32
 */
public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
