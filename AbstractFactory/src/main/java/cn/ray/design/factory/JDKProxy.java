package cn.ray.design.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author JOJO
 * @date 2022/7/29 22:05
 * 动态生成代理类
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();

        // 调用Proxy类的newProxyInstance方法来获取一个代理类实例。
        // 这个代理类实现了我们指定的接口并且会把方法调用分发到指定的调用处理器。
        // loader：定义了代理类的ClassLoader
        // interfaces：代理类实现的接口列表
        // h：调用处理器
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
