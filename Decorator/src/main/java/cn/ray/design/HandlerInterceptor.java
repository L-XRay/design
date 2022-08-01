package cn.ray.design;

/**
 * @author JOJO
 * @date 2022/8/1 21:30
 * 模拟Spring中的HandlerInterceptor
 * 实际的单点登录开发会基于； org.springframework.web.servlet.HandlerInterceptor 实现
 */
public interface HandlerInterceptor {
    boolean preHandle(String request,String response,Object handler);
}
