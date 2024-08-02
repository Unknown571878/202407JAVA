package java0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Ex7 {

	public static void main(String[] args) {
		List<Score> list = new ArrayList<Score>();
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Select * from score";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				list.add(new Score(num, name, kor, eng, math));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		list.forEach(System.out::println);
		list.stream().forEach(s->{
			int sum = 0;
			double avg = 0.0;
			sum = s.getEng() + s.getKor() + s.getMath();
			avg = sum/3;
			System.out.println(s.getName() + "의 총점은 " + sum + " 평균은 " + avg);
		});
		
		int korSum = list.stream().mapToInt(s->s.getKor()).sum();
		System.out.println("국어 총점: "+korSum);
		OptionalDouble korAvg = list.stream().mapToInt(s->s.getKor()).average();
		korAvg.ifPresent(avg->System.out.println("국어 평균: " + avg));
		
		int engSum = list.stream().mapToInt(s->s.getEng()).sum();
		System.out.println("영어 총점: "+engSum);
		OptionalDouble engAvg = list.stream().mapToInt(s->s.getEng()).average();
		engAvg.ifPresent(avg->System.out.println("영어 평균: " + avg));
		
		int mathSum = list.stream().mapToInt(s->s.getMath()).sum();
		System.out.println("수학 총점: "+mathSum);
		OptionalDouble mathAvg = list.stream().mapToInt(s->s.getMath()).average();
		mathAvg.ifPresent(avg->System.out.println("수학 평균: " + avg));
	}

}
