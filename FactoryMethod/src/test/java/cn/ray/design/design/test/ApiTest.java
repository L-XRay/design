package cn.ray.design.design.test;

import cn.ray.design.design.StoreFactory;
import cn.ray.design.design.store.ICommodity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/7/29 01:26
 */
public class ApiTest {

    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();

        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);

        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "Ray");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "重庆市.南岸区.XX街道.XXX小区.#18-2109");

        commodityService_2.sendCommodity("10001","9820198721311","1023000020112221113",extMap);

        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);

    }

}
