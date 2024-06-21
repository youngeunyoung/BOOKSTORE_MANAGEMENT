package com.exam.service;

import java.util.List;

import com.exam.dto.CartDTO;
import com.exam.dto.OrderDTO;

public interface OrderService {
	
	/* 주문 정보 */
	public List<OrderDTO> getBooksInfo(List<OrderDTO> orders);
	
}
