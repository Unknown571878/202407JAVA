package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String sql = null;
	
	public void Add_User (String id, String ssn, String name) {
		conn = JDBCUtil.getConnection();
		sql = "insert into User(id,ssn,name) values(?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, ssn);
			stmt.setString(3, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public boolean Join_User (String id, String ssn) {
		conn = JDBCUtil.getConnection();
		boolean exist = false;
		sql = "select * from User where id = ? and ssn = ?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, ssn);
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
	
	public UserDTO Search_User (String id, String ssn) {
		UserDTO dto = null;
		sql = "select * from User where id = ? and ssn = ?";
		conn=JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, ssn);
			rs = stmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO(rs.getInt("userNum"), rs.getString("id"), rs.getString("ssn"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}
	
}
