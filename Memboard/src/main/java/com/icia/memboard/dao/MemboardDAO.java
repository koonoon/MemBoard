package com.icia.memboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memboard.dto.MDTO;


@Repository
public class MemboardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	// 회원가입 메소드
	public int mJoin(MDTO member) {
	System.out.println("[3]가입 DAO : " + member);

		return sql.insert("Member.join", member);
		}

	// 회원목록 메소드
	public List<MDTO> mList() {
		System.out.println("[3]목록 DAO");
		return sql.selectList("Member.list");
	}

	public MDTO mView(String fId) {
		System.out.println("[3]DAO");
		return sql.selectOne("Member.view", fId);
	}

	public int mDelete(String fId) {
		System.out.println("[3]삭제 DAO : " + fId);
		return sql.delete("Member.delete", fId);
	}

	public int mModi(MDTO member) {
		System.out.println("[3]수정 DAO : " + member);
		return sql.update("Member.modi", member);
	}

	public String mLogin(MDTO member) {
		System.out.println("[3]로그인 DAO : " + member);
		return sql.selectOne("Member.login", member);
	}

}
