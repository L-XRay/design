package cn.ray.design;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/3 19:59
 * 这⾥提供的是⼀个享元⼯⼚,通过 map 结构存放已经从库表或者接⼝中查询到的数据
 * 存放到内存中，⽤于下次可以直接获取。
 * 当然也有些时候为了分布式的获取，会把数据存放到redis中，可以按需选择。
 */
public class ActivityFactory {

    static Map<Long, Activity> activityMap = new HashMap<Long, Activity>();

    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // 模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
