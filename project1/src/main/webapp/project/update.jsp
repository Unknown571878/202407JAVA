
<%@page import="project1.UserBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

request.setCharacterEncoding("UTF-8");

int num = Integer.parseInt(request.getParameter("num"));
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

UserBoardDAO dao = new UserBoardDAO();
dao.UpdateBoard(num, title, content, writer);

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