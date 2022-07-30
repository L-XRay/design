package cn.ray.design;

import cn.ray.design.channel.Pay;
import cn.ray.design.channel.WxPay;
import cn.ray.design.channel.ZfbPay;
import cn.ray.design.mode.PayFaceMode;
import cn.ray.design.mode.PayFingerprintMode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author JOJO
 * @date 2022/7/30 19:48
 */
public class ApiTest {

    @Test
    public void test_pay() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }

}
