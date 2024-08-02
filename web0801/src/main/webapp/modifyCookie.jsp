<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 변경</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("name1")){
				Cookie cookie = new Cookie("name1", "kim");
				response.addCookie(cookie);
			}
			
		}
	}
	%>
	name1 쿠키 변경
</body>
</html>