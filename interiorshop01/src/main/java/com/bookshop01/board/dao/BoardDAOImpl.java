package com.bookshop01.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.board.vo.BoardVO;
import com.bookshop01.member.vo.MemberVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List boardList() throws DataAccessException {
		List boardList = sqlSession.selectList("mapper.board.boardList");
		return boardList;
	}


	@Override
	public BoardVO board(int boardNO) throws DataAccessException {
		 
		return sqlSession.selectOne("mapper.board.boardOne", boardNO);
	}

	
	
}
