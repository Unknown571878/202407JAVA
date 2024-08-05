package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private String sql = null;
	
	public void UpdateBoard(int num, String title, String content, String writer) {
		conn = JDBCUtil.getConnection();
		sql = "update userboard set title = ?, writer = ?, content = ?, regtime = now() where boardnum = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, writer);
			stmt.setString(3, content);
			stmt.setInt(4, num);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public int boardwriter (int num) {
		conn = JDBCUtil.getConnection();
		sql = "select usernum from userboard where boardnum = ?";
		int writeruser = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			if(rs.next()) {
				writeruser = rs.getInt("usernum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return writeruser;
		
	}
	
	public UserBoardDTO ViewBoard(int boardnum) {
		conn = JDBCUtil.getConnection();
		UserBoardDTO dto = null;
		sql = "select * from userboard boardnum where boardnum = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			rs = stmt.executeQuery();
			if(rs.next()) {
				dto = new UserBoardDTO(rs.getInt("boardnum"), rs.getString("title"), rs.getString("content")
						,rs.getString("writer"), rs.getString("regtime"), rs.getInt("usernum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return dto;
	}
	
	public void DeleteBoard(String boardnum) {
		conn = JDBCUtil.getConnection();
		sql = "delete from userboard where boardnum = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, boardnum);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public List<UserBoardDTO> boardlist() {
		List<UserBoardDTO> list = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		sql = "select * from userboard";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserBoardDTO dto = new UserBoardDTO(rs.getInt("boardnum"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer"), rs.getString("regtime"), rs.getInt("usernum"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}

	public void InsertBoard(String title, String content, String writer, int usernum) {
		conn = JDBCUtil.getConnection();
		sql = "insert into userboard(title, content, writer, regtime, usernum) values(?, ?, ?, now(), ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, writer);
			stmt.setInt(4, usernum);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
}
