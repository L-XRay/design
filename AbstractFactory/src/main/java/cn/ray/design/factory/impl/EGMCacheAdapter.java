package cn.ray.design.factory.impl;

import cn.ray.design.factory.ICacheAdapter;
import cn.ray.design.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author JOJO
 * @date 2022/7/29 22:24
 */
public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }
}
