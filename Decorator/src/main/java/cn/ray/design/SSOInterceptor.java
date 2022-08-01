package cn.ray.design;

/**
 * @author JOJO
 * @date 2022/8/1 21:33
 * 模拟实现单点登录功能
 */
public class SSOInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        // 这⾥的模拟实现⾮常简单只是截取字符串
        // 实际使⽤需要从 HttpServletRequest request 对象中获取 cookie 信息，解析 ticket 值做校验。
        String ticket = request.substring(1,8);
        // 模拟校验
        return ticket.equals("success");
    }

}
