package edu.kh.todoList.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.todo.model.dto.Todo;
import edu.kh.todoList.todo.model.service.TodoService;

@SessionAttributes({"loginMember"})
//@SessionAttributes의 기능
//1) Model에 세팅된 값의 key와 {} 작성된 값이 일치하면 session scope로 이동
//2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게함
//	-> @SessionAttribute(key)로 사용
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	//Todo 목록 조회
	@GetMapping("/todoList")
	public String todoListAllView(@SessionAttribute("loginMember") Member loginMember,
									Model model) {
		/*
		 * @SessionAttribute("loginMember") Member loginMember
		 *  : Session에서 얻어온 "loginMember"에 해당하는 객체를
		 *    매개변수 Member loginMember에 저장
		 **/
		
		// Todo 목록 조회 서비스 호출
		List<Todo> todoList = service.todoListAllView(loginMember.getMemberNo());
		// 현재 로그인한 회원의 todo목록만 가져와야하기 때문에 로그인한회원의 memberNo를 얻어와 전달함
		
		/* 중간확인
		 * for(Todo todo : todoList) {
			System.out.println(todo);
		}*/
		
		for(Todo todo : todoList) {
			System.out.println(todo);
		}
		
		// 조회 결과를 request scope에 세팅 후 forward
		model.addAttribute("todoList", todoList);
		
		return "todo/todoList";
		
	}
	
	// todo 추가하는 페이지로 이동하는 메서드
	@GetMapping("/todoInsert")
	public String todoInsert() {
		
		// tmeplates/todo/todoInsert.html 로 forward
		return "todo/todoInsert";
		
	}
	
	
	// todo 추가 기능용 메서드
	@PostMapping("/todoInsert")
	public String todoInsert(Todo todo, /*커맨드 객체 (필드에 파라미터값이 담겨있음)*/
							@SessionAttribute("loginMember") Member loginMember,
							RedirectAttributes ra,
							@RequestHeader("referer") String referer
							) {
		
		// 파라미터 : 제목, 내용
		// 세션: 로그인한 회원의 번호
		// 리다이렉트 시 데이터 전달 : RedirectAttributes ra (message)
		
		// 1. 로그인한 회원번호를 얻어와 Todo 에 세팅
		todo.setMemberNo(loginMember.getMemberNo());
		
		// System.out.println(todo);
		
		// 2. Todo 삽입 서비스 호출
		int result = service.todoInsert(todo);
		
		// 3. 삽입 성공 시 todoList(목록)으로 이동
		String path = "redirect:";
		
		if(result > 0) {
			path += "/todo/todoList";
			ra.addFlashAttribute("message", "추가 완료!");
			
		} else {
			
			path += referer;
			ra.addFlashAttribute("message", "아이디 또는 비밀번호 불일치");
			
		}
		
		return path;
		
	}
	
}
