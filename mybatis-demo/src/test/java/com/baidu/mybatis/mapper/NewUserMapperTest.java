package com.baidu.mybatis.mapper;

import com.baidu.mybatis.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/24.
 */
public class NewUserMapperTest {
    @Test
    public void queryUserByPage() throws Exception {
        Map<String, Integer> param = new HashMap<>();
        param.put( "page", 0 );
        param.put( "rows", 2 );
        List<User> list = this.newUserMapper.queryUserByPage( param );
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserByPageHelper() {
        PageHelper.startPage( 1, 2 );
        List<User> list = this.newUserMapper.select( null );
        for (User user : list) {
            System.out.println(user);
        }
        // 分页信息使用PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
    }

    private NewUserMapper newUserMapper;
    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        // 参数为true,设置事务是自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
         newUserMapper = sqlSession.getMapper( NewUserMapper.class );
    }
    @Test
    public void testSelectOne() {
        User param = new User();
        param.setId( 1l );
        User user = this.newUserMapper.selectOne( param );
        System.out.println(user);
    }

}