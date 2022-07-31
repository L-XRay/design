package cn.ray.design.service.engine;

import cn.ray.design.model.aggregates.TreeRich;
import cn.ray.design.model.vo.EngineResult;
import cn.ray.design.model.vo.TreeNode;
import cn.ray.design.model.vo.TreeRoot;
import cn.ray.design.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/1 01:28
 * 基础决策引擎功能
 * 这⾥主要提供决策树流程的处理过程，有点像通过链路的关系( 性别 、 年龄 )在⼆叉树中寻找果实节点的过程。
 * 同时提供⼀个抽象⽅法，执⾏决策流程的⽅法供外部去做具体的实现。
 */
public abstract class EngineBase extends EngineConfig implements IEngine {

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        // 规则树节点
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            String ruleKey = treeNodeInfo.getRuleKey();  // EngineConfig.logicFilterMap.get(ruleKey)
            // 得到指定key的规则
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            // 得到对应规则的决策值
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            // 得到满足规则的下一个节点
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            // 跳转到下一个节点
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }

}
