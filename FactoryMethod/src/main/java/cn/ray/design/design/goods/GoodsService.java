package cn.ray.design.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * @author JOJO
 * @date 2022/7/29 01:03
 * 模拟实物商品服务
 */
public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
