package cn.ray.design.cook.impl;

import cn.ray.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/5 22:17
 * 实现者具体实现(四类厨师)
 */
public class GuangDongCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    @Override
    public void doCooking() {
        logger.info("广东厨师，烹饪粤菜，宫廷最大菜系，以孔府风味为龙头");
    }
}
