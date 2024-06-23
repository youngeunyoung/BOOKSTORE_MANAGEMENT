package com.exam.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;
import com.exam.dto.OrderPageDTO;


@Mapper
public interface OrderPageMapper {

	public void insertOrderPage(OrderPageDTO orderPageDTO);

}
