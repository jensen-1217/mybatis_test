package com.jensen.pojo;

public class OrderItem {
    private Integer id;
    private String goodsName;
    private double goodsPrice;
    private String count;
    private Integer orderId;//订单id（外键）

    public OrderItem() {
    }

    public OrderItem(Integer id, String goodsName, double goodsPrice, String count, Integer orderId) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.count = count;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", count='" + count + '\'' +
                ", orderId=" + orderId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
