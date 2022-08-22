package com.bookshop01.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.board.vo.BoardVO;

public interface BoardController {

	public ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView detailBoard(@RequestParam("boardNO") int boardNO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
