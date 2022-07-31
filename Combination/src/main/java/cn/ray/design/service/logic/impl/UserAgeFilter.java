package cn.ray.design.service.logic.impl;

import cn.ray.design.service.logic.BasicLogic;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/1 00:08
 * 年龄节点逻辑实现类
 */
public class UserAgeFilter extends BasicLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
