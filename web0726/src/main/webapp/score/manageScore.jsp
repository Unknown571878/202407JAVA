<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String num3 = "";
String name3 = "";
String kor3 = "";
String eng3 = "";
String math3 = "";

request.setCharacterEncoding("UTF-8");
String find = request.getParameter("find");
String num = request.getParameter("user");
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt, pstmt2, pstmt3, pstmt4 = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
String sql = "select * from score";
pstmt = conn.prepareStatement(sql);

if (num != null) {
	String sql5 = "select count(*) from score where = ?";
	
	String sql2 = "insert into score(num, name, kor, eng, math) values (?, ?, ?, ?, ?)";
	pstmt2 = conn.prepareStatement(sql2);
	pstmt2.setString(1, num);
	pstmt2.setString(2, name);
	pstmt2.setString(3, kor);
	pstmt2.setString(4, eng);
	pstmt2.setString(5, math);
	int ret = pstmt2.executeUpdate();
}
if (find != null){
	String sql3 = "select * from score where num = ?";
	pstmt3 = conn.prepareStatement(sql3);
	pstmt3.setString(1, find);
	ResultSet rs = pstmt3.executeQuery();
	while (rs.next()) {
		num3 = rs.getString("num");
		name3 = rs.getString("name");
		kor3 = rs.getString("kor");
		eng3 = rs.getString("eng");
		math3 = rs.getString("math");
	}
}
String sql4 = "update score set kor = ?, eng = ?, math = ? where num = ?";
pstmt4 = conn.prepareStatement(sql4);
pstmt4.setString(1, find);
pstmt4.setString(2, find);
pstmt4.setString(3, find);
pstmt4.setString(4, find);
int ret = pstmt4.executeUpdate();

ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		학번: <input name="user" value="<%=num3 %>"><br> 이름: <input name="name" value="<%=name3 %>"><br>
		국어: <input name="kor" value="<%=kor3 %>"><br> 영어: <input name="eng" value="<%=eng3 %>"><br>
		수학: <input name="math" value="<%=math3 %>"><br> <input type="submit"
			value="입력/수정">
	</form>

	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
		<%
		int sum = 0;
		double avg = 0.0;
		while (rs.next()) {
			String callnum = rs.getString("num");
			String callname = rs.getString("name");
			int callkor = rs.getInt("kor");
			int calleng = rs.getInt("eng");
			int callmath = rs.getInt("math");
			sum = callkor + calleng + callmath;
			avg = sum / 3.0;
		%>
		<tr>
			<td><a href="manageScore.jsp?find=<%=callnum%>"><%=callnum%></a></td>
			<td><%=callname%></td>
			<td><%=callkor%></td>
			<td><%=calleng%></td>
			<td><%=callmath%></td>
			<td><%=sum%></td>
			<td><%=avg%></td>
		</tr>
		<%
		}
		%>
	
</body>
</html>