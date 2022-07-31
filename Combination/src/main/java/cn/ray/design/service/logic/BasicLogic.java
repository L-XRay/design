package cn.ray.design.service.logic;

import cn.ray.design.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/7/31 23:46
 * 决策抽象类提供基础服务
 * 在抽象⽅法中实现了接⼝⽅法，同时定义了基本的决策⽅法； 1、2、3、4、5 ， 等于、⼩于、⼤于、⼩于等于、⼤于等于 的判断逻辑。
 * 同时定义了抽象⽅法，让每⼀个实现接⼝的类都必须按照规则提供 决策值 ，这个决策值⽤于做逻辑⽐对
 */
public abstract class BasicLogic implements LogicFilter{

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink nodeLine : treeNodeLinkList) {
            if(decisionLogic(matterValue,nodeLine)) return nodeLine.getNodeIdTo();
        }
        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
        switch (nodeLink.getRuleLimitType()) {
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }
}
