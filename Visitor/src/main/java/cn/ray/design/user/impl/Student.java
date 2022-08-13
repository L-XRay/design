package cn.ray.design.user.impl;

import cn.ray.design.user.User;
import cn.ray.design.visitor.Visitor;

/**
 * @author JOJO
 * @date 2022/8/13 21:47
 */
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
