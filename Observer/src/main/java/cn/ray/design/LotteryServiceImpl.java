package cn.ray.design;

import cn.ray.design.service.LotteryService;
import cn.ray.design.service.MinibusTargetService;

import java.util.Date;

/**
 * @author JOJO
 * @date 2022/8/12 09:25
 */
public class LotteryServiceImpl extends LotteryService {
    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }
}
