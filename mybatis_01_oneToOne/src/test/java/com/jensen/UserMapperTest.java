package com.jensen;

import com.jensen.dao.UserMapper;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void testFindUserById(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(user);
    }

}
