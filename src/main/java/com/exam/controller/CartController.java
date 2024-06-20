package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.CartService;

@Controller
public class CartController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(CartDTO cart, HttpServletRequest request) {
		// 로그인 체크
        HttpSession session = request.getSession();
        MemberDTO login = (MemberDTO) session.getAttribute("login");
        if (login == null) {
            return "5"; // 로그인 안 된 경우
        }
        
     // 카트 등록
     int result = cartService.addCart(cart);
     		
     return result + "";
	}
	
	@GetMapping("/cart/{member_id}")
	public String cartPageGET(@PathVariable("member_id") String member_id, Model model) {

		model.addAttribute("cartInfo", cartService.cartList(member_id));
		
		return "/cart";
	}
}
