package com.baidu.mybatis.mapper;

import com.baidu.mybatis.pojo.User;
import com.github.abel533.mapper.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface NewUserMapper extends Mapper<User> {
    /***
     * w分页查询
     * @param param
     * @return
     */
    List<User> queryUserByPage(Map<String, Integer> param);
}
