package cn.ray.design.appearance.config;

/**
 * @author JOJO
 * @date 2022/8/3 10:32
 * 配置服务类
 */
public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }
}
