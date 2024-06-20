package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.CartDTO;
import com.exam.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartMapper cartMapper;
	
	public CartServiceImpl(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	
	@Override
	public int addCart(CartDTO cart) {
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
		return 2;
		}
		
		return cartMapper.addCart(cart);
	}
	
	@Override
	public int deleteCart(int cart_num) {
		return 0;
		
	}@Override
	public int updateCart(CartDTO cart) {
		return 0;
	}
	
	@Override
	public List<CartDTO> cartList(String member_id) {
		return cartMapper.cartList(member_id);
	}
	
	@Override
	public CartDTO checkCart(CartDTO cart) {
		return null;
	}

}
