package cn.ray.design;

import cn.ray.design.impl.DDNetMall;
import cn.ray.design.impl.JDNetMall;
import cn.ray.design.impl.TBNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JOJO
 * @date 2022/8/13 19:14
 */
public class ApiTest {

    public Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.html
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall JDMall = new JDNetMall("1000001","*******");
        String base64 = JDMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);

        System.out.println("-------------------------------------");
        NetMall DDMall = new DDNetMall("1000001","*******");
        String poster = DDMall.generateGoodsPoster("http://product.dangdang.com/1509704171.html");
        logger.info("测试结果：{}", poster);

        System.out.println("-------------------------------------");
        NetMall TBMall = new TBNetMall("1000001","*******");
        String base641 = TBMall.generateGoodsPoster("https://detail.tmall.com/item.html");
        logger.info("测试结果：{}", base641);


    }

}
