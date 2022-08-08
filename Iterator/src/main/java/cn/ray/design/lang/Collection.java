package cn.ray.design.lang;

/**
 * @author JOJO
 * @date 2022/8/8 14:45
 */
public interface Collection<E,L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L l);

    boolean removeLink(String key);

    @Override
    Iterator<E> iterator();
}
