import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("지역 입력: ");
		String str = sc.nextLine();
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
//		String sql = "select * from dept where loc = '" + str + "'";
		
		String sql = String.format("select * from dept where loc = '%s'", str);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
//			rs.next();
//			System.out.println(rs.getInt("deptno") + rs.getString("dname") + rs.getString("loc"));
			
			int i =0;
			if(!rs.next()) {
				System.out.println("해당 조건에 알맞는 자료가 없습니다.");
			}
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d %s %s \n", deptno, dname, loc);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
