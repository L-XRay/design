package cn.ray.design.impl;

import cn.ray.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author JOJO
 * @date 2022/8/13 16:36
 */
public class NYCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }

}
