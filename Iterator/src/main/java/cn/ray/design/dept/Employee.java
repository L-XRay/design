package cn.ray.design.dept;

/**
 * @author JOJO
 * @date 2022/8/8 13:58
 * 节点元素 员工
 */
public class Employee {
    private String uId;
    private String name;
    private String desc;

    public Employee(String uId, String name, String desc) {
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
