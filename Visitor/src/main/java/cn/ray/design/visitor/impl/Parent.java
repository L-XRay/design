package cn.ray.design.visitor.impl;

import cn.ray.design.user.impl.Student;
import cn.ray.design.user.impl.Teacher;
import cn.ray.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/13 21:50
 */
public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 排名：{}", student.name, student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);
    }
}
