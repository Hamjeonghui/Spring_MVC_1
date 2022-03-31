package com.test.app.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;

public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 검색 로직 추가할 예정
		BoardVO vo=new BoardVO();
		vo.setSearchCondition(request.getParameter("searchCondition"));
		vo.setSearchKeyword(request.getParameter("searchKeyword"));
		BoardDAO boardDAO=new BoardDAO();
		List<BoardVO> datas=boardDAO.getBoardList(vo);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("datas", datas); // Model을 이용하여 전달할 정보를 저장!
		mav.setViewName("main");
		return mav;
	}

}
