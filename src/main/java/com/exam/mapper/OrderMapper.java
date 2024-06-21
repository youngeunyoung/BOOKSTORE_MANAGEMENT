package com.exam.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;


@Mapper
public interface OrderMapper {

	public OrderDTO getBooksInfo(int book_id);

}
