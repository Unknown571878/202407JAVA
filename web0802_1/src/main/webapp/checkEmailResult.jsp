<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    String check = request.getParameter("rememberMe");
    String email = request.getParameter("email");
    if(check.equals("on")){
    	response.addCookie(Cookies.createCookie("email", email, "/", -1));
    } else {
    	response.addCookie(Cookies.createCookie("email", "", "/", 0));
    }
    response.sendRedirect("checkEmail.jsp");
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