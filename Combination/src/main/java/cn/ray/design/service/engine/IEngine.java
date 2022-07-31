package cn.ray.design.service.engine;

import cn.ray.design.model.aggregates.TreeRich;
import cn.ray.design.model.vo.EngineResult;

import java.util.Map;

/**
 * @author JOJO
 * @date 2022/8/1 00:14
 * 对于使⽤⽅来说也同样需要定义统⼀的接⼝操作
 * 这样的好处⾮常⽅便后续拓展出不同类型的决策引擎，也就是可以建造不同的决策⼯⼚。
 */
public interface IEngine {
    EngineResult process(final Long treeId, final String userId,
                         TreeRich treeRich, final Map<String, String> decisionMatter);
}
