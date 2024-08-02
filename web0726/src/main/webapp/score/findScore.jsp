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
    String sql = "select * from score where num = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, "240001");
    ResultSet rs = pstmt.executeQuery();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

while (rs.next()) {
	String num = rs.getString("num");
	String name = rs.getString("name");
	int kor = rs.getInt("kor");
	int eng = rs.getInt("eng");
	int math = rs.getInt("math");
	out.println(num+" "+name+" "+kor+" "+eng+" "+math);
	}
%>
</body>
</html>