package cn.ray.design.service.logic.impl;

import cn.ray.design.service.logic.BasicLogic;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/1 00:09
 * 性别节点逻辑实现类
 */
public class UserGenderFilter extends BasicLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
