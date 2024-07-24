import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx10 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		String sql = "select deptno, dname, loc from dept";

		Scanner scan = new Scanner(System.in);
		System.out.println("테이블 이름 입력>>");
		String str = scan.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM " + str);
			ResultSetMetaData rsmd = result.getMetaData();
			int numOfcol = rsmd.getColumnCount(); // 컬럼 개수 구하는 법
			System.out.println(numOfcol);
			for (int i = 1; i <= numOfcol; i++) {
				System.out.println(rsmd.getColumnName(i));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
