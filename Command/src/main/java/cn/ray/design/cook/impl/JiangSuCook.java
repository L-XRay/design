package cn.ray.design.cook.impl;

import cn.ray.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/5 22:18
 * 实现者具体实现(四类厨师)
 */
public class JiangSuCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);
    @Override
    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }
}
