<%@page import="project1.UserBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String num = request.getParameter("num");
    UserBoardDAO dao = new UserBoardDAO();
    dao.DeleteBoard(num);
    response.sendRedirect("main.jsp");
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