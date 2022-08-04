package cn.ray.design.appearance.web;

import cn.ray.design.appearance.annotation.DoDoor;
import cn.ray.design.appearance.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JOJO
 * @date 2022/8/3 09:08
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private int port;

    /**
     * @DoDoor 自定义注解
     * key：需要从入参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使用
     * returnJson：预设拦截时返回值，是返回对象的Json
     *
     * http://localhost:8080/api/queryUserInfo?userId=Ray
     * http://localhost:8080/api/queryUserInfo?userId=111
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("Hello,World:" + userId, 19, "重庆市南岸区旮旯胡同100号");
    }
}
