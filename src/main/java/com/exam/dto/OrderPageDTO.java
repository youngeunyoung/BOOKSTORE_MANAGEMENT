package com.exam.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderPageDTO")
public class OrderPageDTO {

    private List<OrderDTO> orders;

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderPageDTO [orders=" + orders + "]";
    }
}
