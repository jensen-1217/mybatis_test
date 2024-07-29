package com.jensen;

import com.jensen.dao.OrderMapper;
import com.jensen.pojo.Order;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class OrderMapperTest {

    @Test
    public void testOneToOne(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.findOrderByNumber("20140921003");
        MyBatisUtil.closeSqlSession(sqlSession);
        User user = order.getOrderUser();
        System.out.println("订单信息"+order);
        System.out.println("下单人信息"+user);
    }

}
