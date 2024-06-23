package com.exam.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;
import com.exam.dto.OrderPageDTO;


@Mapper
public interface OrderMapper {

	public OrderDTO getBooksInfo(int book_id);
	public void insertOrder(OrderDTO order);

}
