package cn.ray.design.dao;

import cn.ray.design.pojo.School;

/**
 * @author JOJO
 * @date 2022/8/10 02:01
 */
public interface ISchoolDao {
    School querySchoolInfoById(Long id);
}
