package com.bookshop01.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.board.service.BoardService;
import com.bookshop01.board.vo.BoardVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{

	@Autowired
	BoardService boardService;
	@Autowired
	BoardVO boardVO;
	
	@Override
	@RequestMapping(value = "admin/board/adminBoardMain.do", method = RequestMethod.GET)
	public ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List listBoard = boardService.listBoard();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("listBoard",listBoard);
		return mav;
	}

	@Override
	@RequestMapping(value = "admin/board/boardDetail.do" , method = RequestMethod.GET)
	public ModelAndView detailBoard(@RequestParam("boardNO")int boardNO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(boardNO);
		boardVO  = boardService.detailBoard(boardNO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("board", boardVO);
		return mav;
	}


	
}
