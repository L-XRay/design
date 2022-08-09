package cn.ray.design.mediator;

/**
 * @author JOJO
 * @date 2022/8/10 01:34
 * 开启⼀个 SqlSession
 * 但是当你有数据库操作的时候都会获取每⼀次执⾏的 SqlSession 。
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
