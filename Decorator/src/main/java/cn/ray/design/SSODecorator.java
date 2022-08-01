package cn.ray.design;

/**
 * @author JOJO
 * @date 2022/8/1 21:38
 * 在装饰类中有三个重点的地⽅是；1)继承了处理接⼝、2)提供了构造函数、3)覆盖了⽅法preHandle 。
 */
public abstract class SSODecorator implements HandlerInterceptor{

    private HandlerInterceptor handlerInterceptor;

    private SSODecorator(){}

    public SSODecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request,response,handler);
    }
}
