package cn.ray.design;

import cn.ray.design.dept.DeptStructure;
import cn.ray.design.dept.Employee;
import cn.ray.design.dept.Link;
import cn.ray.design.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/8 15:21
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_iterator() {
        DeptStructure deptStructure = new DeptStructure("1", "Ray");
        deptStructure.add(new Employee("2", "花花", "二级部门"));
        deptStructure.add(new Employee("3", "豆包", "二级部门"));
        deptStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        deptStructure.add(new Employee("5", "大烧", "三级部门"));
        deptStructure.add(new Employee("6", "虎哥", "四级部门"));
        deptStructure.add(new Employee("7", "玲姐", "四级部门"));
        deptStructure.add(new Employee("8", "秋雅", "四级部门"));

        deptStructure.addLink("1", new Link("1", "2"));
        deptStructure.addLink("1", new Link("1", "3"));

        deptStructure.addLink("2", new Link("2", "4"));
        deptStructure.addLink("2", new Link("2", "5"));

        deptStructure.addLink("5", new Link("5", "6"));
        deptStructure.addLink("5", new Link("5", "7"));
        deptStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = deptStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            logger.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
        }

    }
}
