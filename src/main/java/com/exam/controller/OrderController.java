package com.exam.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.dto.OrderPageDTO;
import com.exam.service.CartService;
import com.exam.service.MemberService;
import com.exam.service.OrderService;

@Controller
@SessionAttributes(names = {"login"})
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Lazy
	OrderService orderService;
	@Lazy
	MemberService memberService;
	
	public OrderController(OrderService orderService,MemberService memberService) {
		this.orderService = orderService;
		this.memberService = memberService;
		
	}

	@GetMapping("/order")
	public String orderPageGET(@PathVariable("member_id") String member_id, OrderPageDTO opd, Model m) {
		
		m.addAttribute("orderList", orderService.getBooksInfo(opd.getOrders()));
		m.addAttribute("memberInfo", memberService.getMemberInfo(member_id));
		
		return "/order";
	
	}
	
}