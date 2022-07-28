package cn.ray.design;

import cn.ray.design.store.ICommodity;
import cn.ray.design.store.impl.CardCommodityService;
import cn.ray.design.store.impl.CouponCommodityService;
import cn.ray.design.store.impl.GoodsCommodityService;

/**
 * @author JOJO
 * @date 2022/7/29 01:12
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
