package cn.ray.design.user;

import cn.ray.design.visitor.Visitor;

/**
 * @author JOJO
 * @date 2022/8/13 21:45
 */
public abstract class User {

    public String name;      // 姓名
    public String identity;  // 身份；重点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz;     // 班级

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    // 核心访问方法
    public abstract void accept(Visitor visitor);
}
