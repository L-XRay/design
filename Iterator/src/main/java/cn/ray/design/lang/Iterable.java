package cn.ray.design.lang;

/**
 * @author JOJO
 * @date 2022/8/8 14:41
 * 可迭代接口定义
 */
public interface Iterable<E> {

    Iterator<E> iterator();
}
