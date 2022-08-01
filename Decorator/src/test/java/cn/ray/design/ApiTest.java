package cn.ray.design;

import org.junit.Test;

/**
 * @author JOJO
 * @date 2022/8/1 21:48
 */
public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        LoginSSODecorator ssoDecorator = new LoginSSODecorator(new SSOInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}
