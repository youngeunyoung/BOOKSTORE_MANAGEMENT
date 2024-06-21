package com.exam.service;

import java.util.List;

import com.exam.dto.CartDTO;

public interface CartService {

	public int addCart(CartDTO cart);
	public int deleteCart(int cart_num);
	public int updateCart(CartDTO cart);
	public List<CartDTO> cartList(String member_id);
	public CartDTO checkCart(CartDTO cart);
	
}
