package cn.ray.design;

import cn.ray.design.utils.RedisUtil;

/**
 * @author JOJO
 * @date 2022/8/3 20:00
 */
public class ActivityController {

    private RedisUtil redisUtil = new RedisUtil();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtil.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
