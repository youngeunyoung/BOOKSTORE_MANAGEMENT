package com.exam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String mypage(@ModelAttribute("login") MemberDTO dto, ModelMap m,HttpServletRequest hs) {
		HttpSession session = hs.getSession();
		
	    MemberDTO login = (MemberDTO) session.getAttribute("login");
	    System.out.println("########");
		logger.info("logger:mypage:{}", dto);
		String Member_id = dto.getMember_id();
		
		MemberDTO searchDTO = memberService.mypage(Member_id);
		m.addAttribute("login", searchDTO);
		
		return "mypage";
	}
    
    // 마이페이지 정보 업데이트 처리
    @PostMapping("/mypage")
    public String updateMypage(@Valid @ModelAttribute("login") MemberDTO updatedDTO, BindingResult result,
    		ModelMap model) {
          	if (result.hasErrors()) {
    		model.addAttribute("errorMessage", "변경 실패");
        	System.out.println("실패");
            // 유효성 검사 에러가 발생할 경우 처리
            return "redirect:main2"; // 다시 마이페이지 폼으로 돌아감
        }
        
        memberService.updateMypage(updatedDTO);
        model.addAttribute("successMessage", "변경 성공");// 서비스를 통해 정보 업데이트
        System.out.println("성공");
        return "redirect:main2"; // 업데이트 후 다시 마이페이지로 리다이렉트
    }
	
}






