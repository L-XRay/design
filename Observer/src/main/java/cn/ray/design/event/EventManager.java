package cn.ray.design.event;

import cn.ray.design.LotteryResult;
import cn.ray.design.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/12 09:01
 * 整个处理的实现上提供了三个主要⽅法；订阅( subscribe )、取消订阅( unsubscribe )、通知( notify )
 * 这三个⽅法分别⽤于对监听事件的添加和使⽤。
 * 另外因为事件有不同的类型，这⾥使⽤了枚举的⽅式进⾏处理，
 * ⽅便让外部在规定下使⽤事件，⽽不⾄于乱传信息( EventType.MQ 、 EventType.Message )。
 */
public class EventManager {
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public enum EventType {
        MQ, Message
    }

    /**
     * 订阅
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     * @param eventType 事件类型
     * @param result    结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }

}
