package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색하실 테이블 이름을 입력하시오: ");
		String table = sc.nextLine();
		String sql = "select * from "+table;
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
//				System.out.print(rs.getString("customer_id") + ", ");
//				System.out.println(rs.getString("customer_name"));
				System.out.print(rs.getString(1) + ", ");
				System.out.println(rs.getString(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
