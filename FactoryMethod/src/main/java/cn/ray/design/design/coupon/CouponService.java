package cn.ray.design.design.coupon;

/**
 * @author JOJO
 * @date 2022/7/29 01:02
 * 模拟优惠券发放服务
 */
public class CouponService {
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid){
        System.out.println("模拟发放优惠券一张: "+uId+","+couponNumber+","+uuid);
        return new CouponResult("200","发放成功");
    }
}
