package com.test.app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String bid=request.getParameter("bid");
		BoardVO vo=new BoardVO();
		vo.setBid(Integer.parseInt(bid));
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.deleteBoard(vo);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:main.do");
		return mav;
	}

}
