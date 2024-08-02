<%@page import="web0801.AccountDTO"%>
<%@page import="web0801.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String tel = request.getParameter("tel");
    
    AccountDAO dao = new AccountDAO();
    dao.RegistAccount(new AccountDTO(username, password, tel));
    out.println("<script type='text/javascript'>");
    out.println("alert('회원가입 성공!');");
    out.println("window.location.href = 'index.jsp';");
    out.println("</script>");
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