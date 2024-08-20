package com.board.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
		SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
		SqlSession session;
		
		public BoardDAO() {
			// SqlSessionFactory에서 session을 할당받는다.
			// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
			// default는 false이다.
			session = sqlsession_f.openSession(true);
		}
		public int getNumRecords() {
			return session.selectOne("BoardMapper.getNumRecords");
		}

		public List<BoardDTO> selectList(int start, int listSize) {
			// session을 통해 쿼리를 실행하고 값을 받아온다.
			Map<String, Integer> map = new HashMap<>();
			map.put("start", start);
			map.put("listSize", listSize);
			return session.selectList("BoardMapper.selectList", map);
		}
		
		public List<BoardDTO> ListView(){
			return session.selectList("BoardMapper.selectList");
		}

		public void insertOne(BoardDTO product) {
			session.insert("ProductMapper.insertProduct", product);
		}

		public BoardDTO selectOne(int id, boolean flag) {
			return session.selectOne("ProductMapper.selectProductById", id);
		}

		public void updateOne(BoardDTO product) {
			session.update("ProductMapper.updateProduct", product);
		}

		public boolean deleteOne(int id) {
			try {
				session.update("ProductMapper.deleteProduct", id);
			} catch(Exception e) {
				System.out.println("여기!!!");
				//e.printStackTrace();
				return true;
			}
			return false;
			
		}
		
		public void decreaseStock(int id) {
			session.update("ProductMapper.decreaseStock", id);
		}
		
		public int countProducts(int id) {
			return session.selectOne("ProductMapper.countProducts", id);
		}
}
