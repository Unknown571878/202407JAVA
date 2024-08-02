
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
        
    int num = Integer.parseInt(request.getParameter("num"));
    
    BoardDAO dao = new BoardDAO();
    dao.deleteBoard(num);
    
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