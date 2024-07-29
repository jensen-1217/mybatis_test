package com.jensen.dao;

import com.jensen.pojo.Order;
import com.jensen.pojo.OrderItem;

public interface OrderMapper {

    public int addOrder(Order order);

    public int addOrderItem(OrderItem orderItem);
}
