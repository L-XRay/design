package cn.ray.design.impl;

import cn.ray.design.HttpClient;
import cn.ray.design.NetMall;
import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JOJO
 * @date 2022/8/13 19:05
 */
public class DDNetMall extends NetMall {

    public DDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        logger.info("模拟当当用户登录 uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "4548.00");
        logger.info("模拟当当商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟生成当当商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
