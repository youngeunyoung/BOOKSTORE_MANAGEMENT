package com.exam.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.CartDTO;


@Mapper
public interface CartMapper {

	public int addCart(CartDTO cart);
	public int deleteCart(int cart_num);
	public int updateCart(CartDTO cart);
	public List<CartDTO> cartList(String member_id);
	public CartDTO checkCart(CartDTO cart);

}
