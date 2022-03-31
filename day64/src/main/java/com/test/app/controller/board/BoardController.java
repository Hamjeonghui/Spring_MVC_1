package com.test.app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;

public class BoardController implements Controller {
	// 1. Controller 교체
	// 2. 반환타입의 변경 -> ModelAndView(무엇을 보낼지_정보_datas,data,member,... + 어디로 가야하는지_경로)

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String bid=request.getParameter("bid");
		BoardVO vo=new BoardVO();
		vo.setBid(Integer.parseInt(bid));
		BoardDAO boardDAO=new BoardDAO();
		vo=boardDAO.getBoard(vo);
		ModelAndView mav=new ModelAndView();
		mav.addObject("data", vo);
		mav.setViewName("board");
		return mav;
	}

}
