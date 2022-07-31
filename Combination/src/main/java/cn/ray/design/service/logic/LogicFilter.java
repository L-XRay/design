package cn.ray.design.service.logic;

import cn.ray.design.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author JOJO
 * @date 2022/7/31 23:40
 * 树节点逻辑过滤器接口
 * 这⼀部分定义了适配的通⽤接⼝，逻辑决策器、获取决策值
 * 每⼀个提供决策能⼒的节点都必须实现此接⼝，保证统⼀性
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue 决策值<->提供的数据，规则是在链接定义的
     * @param treeNodeLinkList 决策节点
     * @return 下一个节点
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料,即提供的数据
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);
}