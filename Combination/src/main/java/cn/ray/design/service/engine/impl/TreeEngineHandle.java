package cn.ray.design.service.engine.impl;

import cn.ray.design.model.aggregates.TreeRich;
import cn.ray.design.model.vo.EngineResult;
import cn.ray.design.model.vo.TreeNode;
import cn.ray.design.service.engine.EngineBase;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/1 02:29
 * 决策引擎的实现类
 */
public class TreeEngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
