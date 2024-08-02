
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

request.setCharacterEncoding("UTF-8");

int num = Integer.parseInt(request.getParameter("num"));
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String regtime = "";
int hits = 0;





BoardDAO dao = new BoardDAO();
BoardDTO dto = new BoardDTO(num, writer, title, content, regtime, hits);
dao.updateBoard(dto);

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