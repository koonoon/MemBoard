package com.icia.memboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memboard.dto.BoardDTO;
import com.icia.memboard.dto.PageDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	// 게시글 작성 메소드
	public int bWrite(BoardDTO board) {
		System.out.println("[3]작성 dao : " + board);
		return sql.insert("Board.write",board);
	}

	// 게시글 목록 메소드
	public List<BoardDTO> bList() {
		System.out.println("[3]목록 DAO");
		return sql.selectList("Board.list");
	}

	// 게시글 상세보기 메소드
	public BoardDTO bView(int bNum) {
		System.out.println("[3]상세 DAO");
		
		// (1) 조회수 증가 
		sql.update("Board.hit", bNum);
		
		// (2) 상세보기
		return sql.selectOne("Board.view", bNum);
	}

	// 게시글 수정 메소드
	public int bModify(BoardDTO board) {
		System.out.println("[3]수정 DAO : " + board);
		return sql.update("Board.modify", board);
	}

	// 게시글 삭제 메소드
	public int bDelete(int bNum) {
		System.out.println("[3]삭제 DAO : " + bNum);
		return sql.delete("Board.delete", bNum);
	}

	// 게시글 갯수 구하는 메소드
	public int bCount() {
		return sql.selectOne("Board.count");
	}

	public List<BoardDTO> pList(PageDTO paging) {
		System.out.println("[3]페이징 DAO : " + paging);
		return sql.selectList("plist", paging);
	}

}
