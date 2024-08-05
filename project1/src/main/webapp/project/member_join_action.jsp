<%@page import="project1.UserDTO"%>
<%@page import="project1.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	UserDAO dao = new UserDAO();
	String id = request.getParameter("id");
	String ssn = request.getParameter("ssn");
	String name = request.getParameter("name");

	if (id.equals("") || ssn.equals("") || name.equals("")) {
	%>
	<script>
		alert('정보를 입력해주세요');
		history.back()
	</script>
	<%
	}
	if (dao.Join_User(id, ssn)) {
	%>
	<script>
		alert('이미 등록된 아이디입니다.');
		history.back()
	</script>
	<%
	} else {
	dao.Add_User(id, ssn, name);
	%>
	<script>
		alert('가입이 완료되었습니다.');
		window.close();
	</script>
	<%
	}
	response.sendRedirect("index.jsp");
	%>
</body>
</html>