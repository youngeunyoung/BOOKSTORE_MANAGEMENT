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
			checkCart.setQuantity(checkCart.getQuantity() + cart.getQuantity());
		return cartMapper.updateCart(checkCart);

		// 현재 재고에 따라서 최대 장바구니 갯수 제한이 들어가야한ㄷ
		}	
		return cartMapper.addCart(cart);
	}
	
	@Override
	public int deleteCart(int cart_num) {
		return cartMapper.deleteCart(cart_num);
		
	}@Override
	public int updateCart(CartDTO cart) {
		return cartMapper.updateCart(cart);
	}
	
	@Override
	public List<CartDTO> cartList(String member_id) {
		return cartMapper.cartList(member_id);
	}
	
	@Override
	public CartDTO checkCart(CartDTO cart) {
		return cartMapper.checkCart(cart);
	}

}
