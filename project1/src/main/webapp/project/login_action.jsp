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
	String id = request.getParameter("id");
	String ssn = request.getParameter("ssn");

	if (id.equals("") || ssn.equals("")) {
	%>
	<script>
            alert('정보를 입력해주세요');
            history.back()
        </script>
	<%
	} else {

	UserDAO dao = new UserDAO();
	if (dao.Join_User(id, ssn)) {
		UserDTO dto = dao.Search_User(id, ssn);
		session.setAttribute("userNum", dto.getUserNum());
		session.setAttribute("login_name", dto.getName());
	%>
	<script>
		alert('<%=session.getAttribute("login_name")%>
		님 환영합니다.');
		history.back()
	</script>
	<%
	response.sendRedirect("index.jsp");
	} else {
	%>
	<script>
		alert('입력 정보가 틀렸습니다');
		history.back()
	</script>
	<%
	}
	}
	%>
</body>
</html>