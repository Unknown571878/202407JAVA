package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("dept 테이블의 입력할 데이터를 작성해 주세요.");
		System.out.println("DEPTNO: ");
		int deptno = Integer.parseInt(sc.nextLine());
		System.out.println("DNAME: ");
		String dname = sc.nextLine();
		System.out.println("LOC: ");
		String loc = sc.nextLine();
		
		String createString = "insert into dept values('" + deptno + "', '" + dname + "','" + loc + "');";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블에 삽입! " + num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
