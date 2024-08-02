<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String URL = "jdbc:mysql://localhost:3307/spring5fs";
    Connection conn = null;
    PreparedStatement pstmt = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");
    String sql = "select * from score";
    pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 성적</title>
</head>
<body>
<table border="1">
<tr><td>학번</td><td>이름</td><td>국어</td><td>영어</td><td>수학</td><td>총점</td><td>평균</td></tr>
<%
int sum = 0;
double avg = 0.0;
while (rs.next()) {
	String num = rs.getString("num");
	String name = rs.getString("name");
	int kor = rs.getInt("kor");
	int eng = rs.getInt("eng");
	int math = rs.getInt("math");
	sum = kor + eng + math;
	avg = sum / 3.0;
	%>
	<tr><td><%=num %></td><td><%=name %></td><td><%=kor %></td><td><%=eng %></td><td><%=math %></td><td><%=sum %></td><td><%=avg %></td></tr>
	<%
	}
%>
</table>
</body>
</html>