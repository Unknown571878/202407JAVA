import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호: ");
		String strno = sc.nextLine();
		System.out.println("부서명: ");
		String strname = sc.nextLine();
		System.out.println("부서지역: ");
		String strloc = sc.nextLine();
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		
		String sql = String.format("insert into dept(deptno, dname, loc) values(%s, '%s', '%s')", strno, strname, strloc);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
