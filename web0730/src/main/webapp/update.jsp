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
String sql = "";

request.setCharacterEncoding("UTF-8");

String num = "";
String title = "";
String writer = "";
String content = "";
String regtime = "";

num = request.getParameter("num");
title = request.getParameter("title");
writer = request.getParameter("writer");
content = request.getParameter("content");


	sql = "update board set title = ?, writer = ?, content = ?, regtime = now() where num = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, writer);
	pstmt.setString(2, title);
	pstmt.setString(3, content);
	pstmt.setString(4, num);
	int ret = pstmt.executeUpdate();


response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>