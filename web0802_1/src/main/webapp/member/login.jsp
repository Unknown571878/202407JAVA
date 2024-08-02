<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    
    if(id.equals(password)){
    	response.addCookie(Cookies.createCookie("AUTH", id, "/", -1)); // -1은 브라우저를 닫을 때 쿠키가 사라지도록
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>로그인에 성공했습니다
</body>
</html>
<%
}else{
%>
<script>
	alert("로그인에 실패하였습니다.");
	history.go(-1); // 이전 페이지로 이동
</script>
<%
}
%>