package cn.ray.design.cook.impl;

import cn.ray.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author JOJO
 * @date 2022/8/5 22:20
 * 实现者具体实现(四类厨师)
 */
public class SiChuanCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);
    @Override
    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }
}
