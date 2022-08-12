package cn.ray.design.event.listener;

import cn.ray.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/12 09:03
 */
public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }

}
