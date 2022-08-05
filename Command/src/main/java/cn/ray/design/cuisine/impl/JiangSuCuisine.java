package cn.ray.design.cuisine.impl;

import cn.ray.design.cook.ICook;
import cn.ray.design.cuisine.ICuisine;

/**
 * @author JOJO
 * @date 2022/8/5 22:15
 * 具体命令实现(四种菜品)
 */
public class JiangSuCuisine implements ICuisine {
    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
