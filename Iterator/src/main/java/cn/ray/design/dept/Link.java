package cn.ray.design.dept;

/**
 * @author JOJO
 * @date 2022/8/8 14:19
 * 节点链路
 */
public class Link {
    private String fromId;
    private String toId;

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
