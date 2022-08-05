package cn.ray.design;

import cn.ray.design.cook.impl.GuangDongCook;
import cn.ray.design.cook.impl.JiangSuCook;
import cn.ray.design.cook.impl.ShanDongCook;
import cn.ray.design.cook.impl.SiChuanCook;
import cn.ray.design.cuisine.ICuisine;
import cn.ray.design.cuisine.impl.GuangDongCuisine;
import cn.ray.design.cuisine.impl.JiangSuCuisine;
import cn.ray.design.cuisine.impl.ShanDongCuisine;
import cn.ray.design.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

/**
 * @author JOJO
 * @date 2022/8/5 22:22
 */
public class ApiTest {

    @Test
    public void test() {

        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDongCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        Order xiaoEr = new Order();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }
}
