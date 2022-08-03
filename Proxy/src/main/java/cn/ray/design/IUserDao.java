package cn.ray.design;

import cn.ray.design.agent.Select;

/**
 * @author JOJO
 * @date 2022/8/3 21:39
 */
public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}