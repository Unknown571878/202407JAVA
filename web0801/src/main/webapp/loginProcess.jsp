<%@page import="web0801.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%

	request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    System.out.println(username + " " + password);
    
    AccountDAO dao = new AccountDAO();
 
    if (dao.loginAccount(username, password)) {
        out.println("<h2>Login 성공! Welcome, " + username + ".</h2>");
        // 로그인 성공, 쿠키 설정
        Cookie loginCookie = new Cookie("username", username);
        loginCookie.setMaxAge(60 * 60); // 1시간 동안 유효
        response.addCookie(loginCookie);
        out.println("<script type='text/javascript'>");
        out.println("alert('환영합니다, " + username + "!');");
        out.println("window.location.href = 'index.jsp';");
        out.println("</script>");
     
    
    } else {
    	out.println("<script type='text/javascript'>");
        out.println("alert('로그인 실패!');");
        out.println("window.location.href = 'index.jsp';");
        out.println("</script>");
    }

%>
</body>
</html>