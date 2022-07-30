package cn.ray.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/7/30 19:46
 */
public class PayFingerprintMode implements IPayMode{

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return false;
    }
}
