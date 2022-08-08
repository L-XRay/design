package cn.ray.design.lang;

/**
 * @author JOJO
 * @date 2022/8/8 14:22
 * 迭代器定义
 */
public interface Iterator<E> {

    boolean hasNext();  // 判断是否有下一个元素

    E next();  // 获取下一个元素
}
