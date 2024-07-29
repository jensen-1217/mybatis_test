package com.jensen;

import com.jensen.dao.UserMapper;
import com.jensen.pojo.Order;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void testFindUserByLike(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByLike("白");
        for (User user : userList) {
            sqlSession.close();
            System.out.println(user);
        }
    }

    @Test
    public void testAddUserGetPK(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUserName("baiyan1123");
        user.setPassword("123123");
        user.setName("白岩1123");
        user.setSex(0);
        user.setAge(23);
        int count = userMapper.addUserGetPK(user);
        if (count>0){
            User user1 = userMapper.findUserById(user.getId().intValue());
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("添加成功");
            System.out.println(user1);
        }
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.updateUser("baiyan", "123456");
        if (count>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("修改成功");
        }
    }

    @Test
    public void testFindAllUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("baiyan");
        user.setPassword("123123");
        user.setName("白岩");
        user.setSex(1);
        user.setAge(23);
        int count = userMapper.addUser(user);
        if (count>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("添加成功");
        }
    }

    @Test
    public void testFindUserById(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println("用户信息"+user);
    }

}
