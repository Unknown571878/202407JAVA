<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String num = request.getParameter("user");
    String name = request.getParameter("name");
    String kor = request.getParameter("kor");
    String eng = request.getParameter("eng");
    String math = request.getParameter("math");
    String URL = "jdbc:mysql://localhost:3307/spring5fs";
    Connection conn = null;
    PreparedStatement pstmt = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");
    String sql = "insert into score(num, name, kor, eng, math) values (?, ?, ?, ?, ?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, num);
    pstmt.setString(2, name);
    pstmt.setString(3, kor);
    pstmt.setString(4, eng);
    pstmt.setString(5, math);
    int ret = pstmt.executeUpdate();
    out.println(ret + "건 insert 성공!");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

%>
</body>
</html>