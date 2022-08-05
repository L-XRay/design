package cn.ray.design;

import cn.ray.design.impl.Level1AuthLink;
import cn.ray.design.impl.Level2AuthLink;
import cn.ray.design.impl.Level3AuthLink;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @author JOJO
 * @date 2022/8/5 08:31
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000011", "JOJO")
                .appendNext(new Level2AuthLink("1000012", "QQ")
                        .appendNext(new Level1AuthLink("1000013", "Ray")));

        logger.info("测试结果1：{}", JSON.toJSONString(authLink.doAuth("124", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，Ray");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("124", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，QQ");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("124", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，JOJO");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("124", "1000998004813441", new Date())));

    }

}

