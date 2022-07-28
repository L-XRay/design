package cn.ray.design.store;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/7/29 01:16
 */
public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
