package com.board.db;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class AccountDAO {
	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public AccountDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}
	public void insertOne(AccountDTO dto) {
		session.insert("AccountMapper.insertAccount", dto);
	}
	
	public AccountDTO loginAccount(String id, String pw) {
		AccountDTO dto = new AccountDTO();
		dto.setId(id);
		dto.setPw(pw);
		return session.selectOne("AccountMapper.loginAccount", dto);
	}
	
	public AccountDTO accountInfo(int usernum) {
		return session.selectOne("AccountMapper.accountInfo", usernum);
	}
	
	public void updateAccount(AccountDTO accountDTO) {
		session.update("AccountMapper.updateAccount", accountDTO);
	}
	
	public boolean deleteAccount(int usernum) {
		try {
			session.update("AccountMapper.deleteAccount", usernum);
		} catch(Exception e) {
			System.out.println("여기!!!");
			//e.printStackTrace();
			return true;
		}
		return false;
	}
}
