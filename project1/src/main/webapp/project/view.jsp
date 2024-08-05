<%@page import="project1.UserBoardDTO"%>
<%@page import="project1.UserBoardDAO"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int num = Integer.parseInt(request.getParameter("num"));
    UserBoardDAO dao = new UserBoardDAO();
    UserBoardDTO dto = dao.ViewBoard(num);
    UserBoardDAO dao2 = new UserBoardDAO();
    int writeruser = dao2.boardwriter(num);
    int usernum = (Integer) session.getAttribute("userNum");
    %>
    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
    <tr>
        <th>제목</th>
        <td><%=dto.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=dto.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=dto.getRegtime() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=dto.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='main.jsp'">
<%
if(writeruser == usernum){
%>
<input type="button" value="수정"
       onclick="location.href='write2.jsp?num=<%=num %>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num %>'">
<%} %>
</body>
</html>
