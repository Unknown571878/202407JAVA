<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>To 페이지</h1>
${i}단<br>
<c:forEach var="gugu" begin="1" end="9">
${i} x ${gugu} = ${gugu*i}<br>
</c:forEach>
</body>
</html>