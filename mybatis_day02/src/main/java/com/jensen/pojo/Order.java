package com.jensen.pojo;

//订单
public class Order {
    private Integer id;//主键
    private Double payment;
    private Integer paymentType;
    private Integer status;

    public Order() {
    }

    public Order(Integer id, Double payment, Integer paymentType, Integer status) {
        this.id = id;
        this.payment = payment;
        this.paymentType = paymentType;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
