package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3 {
	public static void main(String[] args) {
		String createString = "CREATE TABLE emp " +
	"(empno int(11) not null, " +
	"ename varchar(10) default null, " +
	"job varchar(9) default null, " +
	"mgr int(11) default null, " +
	"hiredate date default null, " +
	"sal int(11) default null, " +
	"comm int(11) default null, " +
	"deptno int(11) default null);";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 생성! " + num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
