package cn.ray.design;

import cn.ray.design.cook.ICook;
import cn.ray.design.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JOJO
 * @date 2022/8/5 22:22
 * 调⽤者(服务员)
 */
public class Order {

    private Logger logger = LoggerFactory.getLogger(ICook.class);
    private List<ICuisine> cuisines = new ArrayList<>();

    public void order(ICuisine cuisine){
        cuisines.add(cuisine);
    }

    public void placeOrder(){
        for (ICuisine cuisine:cuisines) {
            cuisine.cook();
        }
        cuisines.clear();
    }
}
