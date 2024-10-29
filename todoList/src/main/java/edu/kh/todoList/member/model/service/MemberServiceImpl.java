package edu.kh.todoList.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.todoList.member.model.dao.MemberDAO;
import edu.kh.todoList.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO dao;

	@Override
	public Member login(Member inputMember) {
		// dao 메서드 호출
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우
			
			loginMember.setMemberPw(null);
			
		} 
		
		return loginMember;
	}
	
	
}
