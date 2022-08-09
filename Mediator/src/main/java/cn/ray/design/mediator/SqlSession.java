package cn.ray.design.mediator;

import java.util.List;

/**
 * @author JOJO
 * @date 2022/8/10 01:19
 * 对数据库操作的查询接口
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
