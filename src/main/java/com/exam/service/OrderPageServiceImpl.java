package com.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.exam.dto.MemberDTO;
import com.exam.dto.OrderDTO;
import com.exam.dto.OrderPageDTO;
import com.exam.mapper.MemberMapper;
import com.exam.mapper.OrderPageMapper;

@Service
public class OrderPageServiceImpl implements OrderPageService{

	OrderPageMapper orderPageMapper;
	

	public OrderPageServiceImpl(OrderPageMapper orderPageMapper) {
        this.orderPageMapper = orderPageMapper;
    }
	
	@Override
	public void processOrderPage(OrderPageDTO orderPageDTO) {
		for (OrderDTO orderDTO : orderPageDTO.getOrders()) {
            orderDTO.initSaleTotal(); // 총 금액 계산
        }
		
		orderPageMapper.insertOrderPage(orderPageDTO);
	}
}
