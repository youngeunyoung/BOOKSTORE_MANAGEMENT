package com.exam.controller;



import java.time.LocalDate;

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
import com.exam.dto.OrderDTO;
import com.exam.dto.OrderPageDTO;
import com.exam.service.CartService;
import com.exam.service.MemberService;
import com.exam.service.OrderService;
import com.exam.service.OrderPageService;

@Controller
@SessionAttributes(names = {"login"})
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Lazy
	OrderService orderService;
	@Lazy
	MemberService memberService;
	@Lazy
	OrderPageService orderPageService;
	
	public OrderController(OrderService orderService,MemberService memberService, OrderPageService orderPageService) {
		this.orderService = orderService;
		this.memberService = memberService;
		this.orderPageService = orderPageService;
		
	}

	@GetMapping("/order")
	public String orderPageGET(@RequestParam("member_id") String member_id, OrderPageDTO opd, Model m) {
		logger.info("GET request for order page, member_id: {}", member_id);
		
		// 주문 페이지에서 필요한 멤버 정보를 가져와서 모델에 추가
        MemberDTO memberInfo = memberService.getMemberInfo(member_id);
        m.addAttribute("memberInfo", memberInfo);
		/*m.addAttribute("orderList", orderService.getBooksInfo(opd.getOrders()));
		m.addAttribute("memberInfo", memberService.getMemberInfo(member_id));
		*/
		return "order";
	
	}
	
	@PostMapping("/order")
    public String orderPagePost(OrderPageDTO orderPageDTO, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
        MemberDTO login = (MemberDTO) session.getAttribute("login");
        if (login == null) {
            return "redirect:/login";
        }

        // OrderPageDTO에서 주문 정보를 받아서 처리
        orderPageDTO.getOrders().forEach(orderDTO -> {
            orderDTO.setMember_id(login.getMember_id()); // 회원 ID 설정
            orderDTO.setOrderDate(LocalDate.now()); // 주문 날짜 설정
            orderDTO.initSaleTotal(); // 총 가격 계산
            orderService.processOrder(orderDTO); // 주문 처리 서비스 호출
        });

        // 주문 완료 확인 페이지로 이동
        model.addAttribute("orderInfo", orderPageDTO.getOrders()); // 주문 정보를 모델에 추가
        return "orderCheck";
    }
	
}