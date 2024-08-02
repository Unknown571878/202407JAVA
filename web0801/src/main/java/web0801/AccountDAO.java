package web0801;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class AccountDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private String LOG_IN = "select * from account where name = ?";
	private String REGIST_ID = "insert into account(name, ssn, tel, balance) values (?,?,?,0)";

	public void RegistAccount(AccountDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(REGIST_ID);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getSsn());
			stmt.setString(3, dto.getTel());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public boolean loginAccount(String username, String password) {
		conn = JDBCUtil.getConnection();
		boolean existuser = false;

		try {
			stmt = conn.prepareStatement(LOG_IN);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("name").equals(username)) {
					if (rs.getString("ssn").equals(password)) {
						existuser = true;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return existuser;
	}

}
