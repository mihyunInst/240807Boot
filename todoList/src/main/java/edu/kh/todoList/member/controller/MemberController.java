package edu.kh.todoList.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;

@SessionAttributes({"loginMember"})
// @SessionAttributes의 기능
//1) Model에 세팅된 값의 key와 {} 작성된 값이 일치하면 session scope로 이동
//2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게함
//	-> @SessionAttribute(key)로 사용
@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	public String login(Member inputMember, 
					/* Member 객체에 있는 필드와 
					 * html에서 input태그에 작성한 값의 name 값과 일치하면 
					 * 자동으로 Member 객체에 세팅해줌*/
					Model model,
					RedirectAttributes ra,
					@RequestHeader("referer") String referer
					) {
						
		// inputMember에 세팅 잘 되어있는지 확인하기
		//System.out.println("inputMember::" + inputMember);
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		String path = "redirect:";
		if(loginMember != null) {
			
			path += "/todo/todoList"; // /todos/todoList 경로로 redirect
			
			model.addAttribute("loginMember", loginMember);
			
		} else { // 로그인 실패
			
			path += referer;
			ra.addFlashAttribute("message", "아이디 또는 비밀번호 불일치");
		}
		
		return path;
		
	}
}
