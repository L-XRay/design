package cn.ray.design.event.listener;

import cn.ray.design.LotteryResult;

/**
 * @author JOJO
 * @date 2022/8/12 09:01
 */
public interface EventListener {

    void doEvent(LotteryResult result);
}
