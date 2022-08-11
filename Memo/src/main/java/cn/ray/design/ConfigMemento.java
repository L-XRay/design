package cn.ray.design;

/**
 * @author JOJO
 * @date 2022/8/11 10:45
 * 配置文件 备忘录
 */
public class ConfigMemento {
    private ConfigFile configFile;

    public ConfigMemento(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }
}
