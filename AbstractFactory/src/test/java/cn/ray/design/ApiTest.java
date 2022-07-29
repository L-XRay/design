package cn.ray.design;

import cn.ray.design.factory.impl.EGMCacheAdapter;
import cn.ray.design.factory.JDKProxy;
import cn.ray.design.factory.impl.IIRCacheAdapter;
import cn.ray.design.impl.CacheServiceImpl;
import org.junit.Test;

/**
 * @author JOJO
 * @date 2022/7/29 22:24
 */
public class ApiTest {
    @Test
    public void test_CacheService() throws Exception {

        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "JOJO");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "Ray");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

        proxy_IIR.del("user_name_01");
        String val03 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val03);

    }
}
