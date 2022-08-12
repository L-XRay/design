package cn.ray.design.service;

import cn.ray.design.LotteryResult;
import cn.ray.design.event.EventManager;
import cn.ray.design.event.listener.MQEventListener;
import cn.ray.design.event.listener.MessageEventListener;

/**
 * @author JOJO
 * @date 2022/8/12 09:17
 * 这种使⽤抽象类的⽅式定义实现⽅法，可以在⽅法中扩展需要的额外调⽤。并提供抽象方法 abstract LotteryResult doDraw(String uId) ，让类的继承者实现。
 * 同时⽅法的定义使⽤的是 protected ，也就是保证将来外部的调⽤⽅不会调⽤到此⽅法，只有调⽤到 draw(String uId) ，才能让我们完成事件通知。
 * 此种⽅式的实现就是在抽象类中写好⼀个基本的⽅法，在⽅法中完成新增逻辑的同时，再增加抽象类的使⽤。⽽这个抽象类的定义会有继承者实现
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener()); // MQ订阅
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener()); // 短信订阅
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
