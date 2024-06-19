package com.exam.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;


@Controller
@SessionAttributes(names = {"login"})
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody  String idCheck(@RequestParam String member_id) {
		MemberDTO dto = memberService.idCheck(member_id);
		String mesg = "사용가능";
		if(dto!=null) {
			mesg = "사용불가";
		}
		return mesg;
	}
	

	@GetMapping("/signup")
	public String signupForm(ModelMap m) {
		
		MemberDTO dto = new MemberDTO();
		m.addAttribute("memberDTO", dto);
		
		return "memberForm";
	}
	@PostMapping("/signup")
	public String signup(@Valid MemberDTO  dto, BindingResult result,@RequestParam Map<String, String> params) {
		
		if(result.hasErrors()) {
			return "memberForm";
		}
		 String email1 = params.get("email1");
		  String email2 = params.get("email2").equals("direct") ? params.get("email2Direct") : params.get("email2");

		  dto.setEmail1(email1);
		  dto.setEmail2(email2);
		//DB연동
		logger.info("logger:signup:{}", dto);
		
		//회원가입서비스호출
		int n = memberService.memberAdd(dto);
		
		return "redirect:main";
	}
	
	
	@GetMapping("/mypage")
	public String mypage(ModelMap m) {
		
		// 세션에 저장된 MemberDTO 얻기
		MemberDTO dto = (MemberDTO)m.getAttribute("login");
		logger.info("logger:mypage:{}", dto);
		String member_id = dto.getMember_id();
		
		MemberDTO searchDTO = memberService.mypage(member_id);
		m.addAttribute("login", searchDTO);
		
		return "mypage";
	}
	@PostMapping("/updateProfile")
	public String updateProfile(@Valid MemberDTO dto, BindingResult result, @RequestParam Map<String, String> params, ModelMap m) {
	    if (result.hasErrors()) {
	        return "errorPage"; // 에러 처리 페이지로 리다이렉트 또는 메시지 출력
	    }

	    String email1 = params.get("email1");
	    String email2 = params.get("email2").equals("direct") ? params.get("email2Direct") : params.get("email2");
	    String phone1 = params.get("phone1");
	    String phone2 = params.get("phone2");
	    String phone3 = params.get("phone3");

	    dto.setEmail1(email1);
	    dto.setEmail2(email2);
	    dto.setPhone1(phone1);
	    dto.setPhone2(phone2);
	    dto.setPhone3(phone3);

	    int n = memberService.updateProfile(dto);

	    if (n > 0) {
	        // 업데이트 성공 시 세션 정보도 업데이트합니다.
	        m.addAttribute("login", dto);
	        return "redirect:mypage";
	    } else {
	        return "errorPage"; // 업데이트 실패 시 에러 처리 페이지로 리다이렉트 또는 메시지 출력
	    }
	}
	
}






