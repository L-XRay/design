package cn.ray.design;

/**
 * @author JOJO
 * @date 2022/8/11 11:02
 * 记录者
 * 增加了保存 saveMemento() 、获取 getMemento(ConfigMemento memento) 。
 * saveMemento ：保存备忘录的时候会创建⼀个备忘录信息，并返回回去，交给管理者处理。
 * getMemento ：获取的之后并不是直接返回，⽽是把备忘录的信息交给现在的配置⽂件this.configFile
 */
public class ConfigOriginator {
    private ConfigFile configFile;

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveMemento(){
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento memento){
        this.configFile = memento.getConfigFile();
    }
}
