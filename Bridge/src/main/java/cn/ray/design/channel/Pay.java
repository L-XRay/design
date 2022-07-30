package cn.ray.design.channel;

import cn.ray.design.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author JOJO
 * @date 2022/7/30 18:38
 */
public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);
    protected IPayMode payMode;

    public Pay(IPayMode payMode){
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
