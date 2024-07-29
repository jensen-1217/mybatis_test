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
    public void testFindUserById(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        MyBatisUtil.closeSqlSession(sqlSession);
        List<Order> orderList = user.getOrders();
        System.out.println("用户信息"+user);
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

}
