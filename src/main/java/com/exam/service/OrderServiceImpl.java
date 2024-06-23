package com.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.MemberDTO;
import com.exam.dto.OrderDTO;
import com.exam.mapper.MemberMapper;
import com.exam.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper orderMapper;
	
	

	@Override
	public List<OrderDTO> getBooksInfo(List<OrderDTO> orders) {
		
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		
		for(OrderDTO orderDTO : orders) {
			OrderDTO booksInfo = orderMapper.getBooksInfo(orderDTO.getBook_id());
			
			booksInfo.setQuantity(orderDTO.getQuantity());
			booksInfo.initSaleTotal();
			result.add(booksInfo);
		}
		return result;
	}

	public void processOrder(OrderDTO od) {
        orderMapper.insertOrder(od);
    }
}
