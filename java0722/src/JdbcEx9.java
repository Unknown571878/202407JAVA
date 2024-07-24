import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("부서명: ");
		String strname = sc.nextLine();
		System.out.println("부서지역: ");
		String strloc = sc.nextLine();
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		
		String maxdept = "select max(deptno) from dept";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(maxdept);
			rs.next(); // 반드시 들어가야함
			String deptno = String.valueOf(rs.getInt("max(deptno)") + 1); //rs.getInt(1) 숫자 넣으면 숫자가 컬럼의 위치를 가르킴
			String sql = String.format("insert into dept(deptno, dname, loc) values(%s, '%s', '%s')", deptno, strname, strloc);
			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
