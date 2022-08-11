package cn.ray.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JOJO
 * @date 2022/8/11 11:47
 * 在这个类中主要实现的核⼼功能就是记录配置⽂件信息，也就是备忘录的效果，之后提供可以回滚和获取的⽅法，拿到备忘录的具体内容。
 * 同时这⾥设置了两个数据结构来存放备忘录，实际使⽤中可以按需设置。 List<ConfigMemento> 、 Map<String, ConfigMemento> 。
 * 最后是提供的备忘录操作⽅法；存放( append )、回滚( undo )、返回( redo )、定向获取( get )，这样四个操作⽅法。
 */
public class Admin {
    private int cursorIdx = 0;
    private List<ConfigMemento> mementoList = new ArrayList<ConfigMemento>();
    private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<String, ConfigMemento>();

    /**
     * 存放备忘录信息
     * @param memento
     */
    public void append(ConfigMemento memento) {
        mementoList.add(memento);
        mementoMap.put(memento.getConfigFile().getVersionNo(), memento);
        cursorIdx++;
    }

    /**
     * 回滚备忘录
     * @return
     */
    public ConfigMemento undo() {
        if (--cursorIdx <= 0) return mementoList.get(0);
        return mementoList.get(cursorIdx);
    }

    /**
     * 滚动备忘录
     * @return
     */
    public ConfigMemento redo() {
        if (++cursorIdx > mementoList.size()) return mementoList.get(mementoList.size() - 1);
        return mementoList.get(cursorIdx);
    }

    /**
     * 获取指定版本备忘录
     * @param versionNo
     * @return
     */
    public ConfigMemento get(String versionNo){
        return mementoMap.get(versionNo);
    }

}
