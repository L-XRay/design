package cn.ray.design.factory;

import cn.ray.design.utils.ClassLoaderUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author JOJO
 * @date 2022/7/29 22:08
 * 动态代理 中介类 调用处理器
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter){
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtil.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
