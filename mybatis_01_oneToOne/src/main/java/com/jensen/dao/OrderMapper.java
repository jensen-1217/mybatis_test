package com.jensen.dao;

import com.jensen.pojo.Order;

public interface OrderMapper {

    public Order findOrderByNumber(String orderNumber);

}
