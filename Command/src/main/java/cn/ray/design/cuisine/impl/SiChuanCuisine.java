package cn.ray.design.cuisine.impl;

import cn.ray.design.cook.ICook;
import cn.ray.design.cuisine.ICuisine;

/**
 * @author JOJO
 * @date 2022/8/5 22:14
 * 具体命令实现(四种菜品)
 */
public class SiChuanCuisine implements ICuisine {
    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
