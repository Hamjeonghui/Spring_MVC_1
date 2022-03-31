package com.test.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.member.MemberVO;
import com.test.app.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		// 1. 사용자가 입력한 정보들을 추출
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		// 2. vo -> dao == DB 연동
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		MemberDAO dao=new MemberDAO();
		vo=dao.getMember(vo);
		
		// 3. 결과화면으로 이동
		ModelAndView mav=new ModelAndView();
		if(vo==null){
			mav.setViewName("redirect:login.jsp"); // 경로를 반환 -> VR의 viewName으로 전달됨
		}
		else{
			HttpSession session=request.getSession();
			session.setAttribute("member", vo);
			mav.setViewName("redirect:main.do"); // 경로를 반환 -> VR의 viewName으로 전달됨
		}
		return mav;
	}

}
