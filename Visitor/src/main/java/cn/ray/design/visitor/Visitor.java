package cn.ray.design.visitor;

import cn.ray.design.user.impl.Student;
import cn.ray.design.user.impl.Teacher;

/**
 * @author JOJO
 * @date 2022/8/13 21:46
 */
public interface Visitor {

    // 访问学生信息
    void visit(Student student);

    // 访问老师信息
    void visit(Teacher teacher);
}
