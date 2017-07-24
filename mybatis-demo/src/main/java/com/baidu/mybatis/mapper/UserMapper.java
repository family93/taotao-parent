package com.baidu.mybatis.mapper;

import com.baidu.mybatis.pojo.User;

/**
 * Created by Administrator on 2017/7/24.
 */

public interface UserMapper {
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(Long id);

    /**
     * 新增
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新
     *
     * @param user
     */
    void updateUserById(User user);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteUserById(Long id);

}
