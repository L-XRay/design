package cn.ray.design.impl;

import cn.ray.design.OrderAdapterService;
import cn.ray.design.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
