package com.baidu.mybatis.mapper;

import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/7/24.
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
         sqlSessionFactory = builder.build( inputStream );
    }

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.queryUserById(6l);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testSaveUser() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(null);
        user.setUserName("韩梅梅");


        userMapper.saveUser(user);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testUpdateUserById() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUserName("lichuanwen");

        userMapper.updateUserById(user);

        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById(6l);

        sqlSession.close();
    }

}


