package cn.ray.design.factory.impl;

import cn.ray.design.factory.ICacheAdapter;
import cn.ray.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author JOJO
 * @date 2022/7/29 22:26
 */
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }

    public void set(String key, String value) {
        iir.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        iir.del(key);
    }
}
