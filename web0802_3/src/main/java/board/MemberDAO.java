package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private String MEMBER_LOGIN = "select * from member where id=? and pw=?";
	private String ID_SEARCH = "select * from member where id=?";
	private String INSERT_MEMBER = "insert into member values(?, ?, ?)";
	private String MEMBER_UPDATE = "update member set pw=?, name=? where id=?";
	
	public void updateMember(String pw, String name, String id) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, pw);
			stmt.setString(2, name);
			stmt.setString(3, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public void addMember (String id, String pw, String name) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(INSERT_MEMBER);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public boolean idSearch(String id) {
		conn = JDBCUtil.getConnection();
		boolean exist = false;
		try {
			stmt = conn.prepareStatement(ID_SEARCH);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return exist;
	}
	
	public MemberDTO memberSearch(String id) {
		conn = JDBCUtil.getConnection();
		MemberDTO dto = null;
		try {
			stmt = conn.prepareStatement(ID_SEARCH);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO(rs.getString("id"),	rs.getString("pw"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}

	public boolean loginMember(String id, String pw) {
		conn = JDBCUtil.getConnection();
		boolean exist = false;
		try {
			stmt = conn.prepareStatement(MEMBER_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return exist;
	}

}
