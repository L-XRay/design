package cn.ray.design;

import cn.ray.design.impl.MJCouponDiscount;
import cn.ray.design.impl.NYCouponDiscount;
import cn.ray.design.impl.ZJCouponDiscount;
import cn.ray.design.impl.ZKCouponDiscount;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/13 16:40
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MJ(){
        Context<Map<String,String>> context = new Context<>(new MJCouponDiscount());
        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("x","100");
        reqMap.put("n","10");
        BigDecimal discountAmount = context.discountAmount(reqMap, new BigDecimal(150));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_NY(){
        Context<Double> context = new Context<>(new NYCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(7D, new BigDecimal(100));
        logger.info("测试结果：N元购优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_ZJ(){
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(50D, new BigDecimal(80));
        logger.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_ZK(){
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.5D, new BigDecimal(80));
        logger.info("测试结果：折扣优惠后金额 {}", discountAmount);
    }

}
