package cn.ray.design.appearance.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author JOJO
 * @date 2022/8/3 10:19
 * 配置类注解定义
 */
@ConfigurationProperties("ray.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}
