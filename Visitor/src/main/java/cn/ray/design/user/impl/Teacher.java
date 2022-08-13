package cn.ray.design.user.impl;

import cn.ray.design.user.User;
import cn.ray.design.visitor.Visitor;

import java.math.BigDecimal;

/**
 * @author JOJO
 * @date 2022/8/13 21:48
 */
public class Teacher extends User {


    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
