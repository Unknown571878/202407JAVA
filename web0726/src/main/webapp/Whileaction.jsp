<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String text = request.getParameter("text");
int count = Integer.parseInt(request.getParameter("count"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for (int i = 0; i < count; i++) {
		out.println(text + "<br>");
	}
	%>
</body>
</html>