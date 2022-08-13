package cn.ray.design.visitor.impl;

import cn.ray.design.user.impl.Student;
import cn.ray.design.user.impl.Teacher;
import cn.ray.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/13 21:49
 */
public class Principal implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 升本率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }

}
