package cn.ray.design.event.listener;

import cn.ray.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/12 09:06
 */
public class MQEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }

}
