package cn.ray.design.dao;

import cn.ray.design.pojo.User;

/**
 * @author JOJO
 * @date 2022/8/10 02:15
 */
public interface IUserDao {
    User queryUserInfoById(Long id);
}
