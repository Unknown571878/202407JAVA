
<%@page import="project1.UserBoardDTO"%>
<%@page import="project1.UserBoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserBoardDAO dao2 = new UserBoardDAO();
List<UserBoardDTO> list = dao2.boardlist();
int userNum = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	width: 680px;
	text-align: center;
}

th {
	background-color: cyan;
}

.num {
	width: 80px;
}

.title {
	width: 230px;
}

.writer {
	width: 100px;
}

.regtime {
	width: 180px;
}

a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: gray;
}

a:hover {
	text-decoration: none;
	color: red;
}
</style>
</head>
<body>

	<h1>
		<a href="index.jsp">Main</a>
	</h1>

	<%
	if (session == null || session.getAttribute("userNum") == null || session.getAttribute("userNum").equals("")) {
	%>
		<script>
		alert('로그인 후 이용 가능합니다');
		history.back()
	</script>
	<%
	} else {
	userNum = (Integer) session.getAttribute("userNum");
	%>

	<form action="logout_form.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	<%
	}
	%>
	<table>
		<tr>
			<th class="num">번호</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="regtime">작성일시</th>
		</tr>
		<%
		int i = 1;
		for (UserBoardDTO dto : list) {
		%>
		<tr>
			<td><%=i%></td>
			<td style="text-align: left;">
				<%
				if (session == null || session.getAttribute("userNum") == null || session.getAttribute("userNum").equals("")) {
				} else {
				%><a href="view.jsp?num=<%=dto.getBoardnum()%>">
					<%
					}
					%><%=dto.getTitle()%></a>
			</td>
			<td><%=dto.getWriter()%></td>
			<td><%=dto.getRegtime()%></td>
			<%
			if (userNum == dto.getUsernum()) {
			%><td><input type="button" value="삭제"
				onclick="location.href='delete.jsp?num=<%=dto.getBoardnum()%>'"></td>
			<%
			}
			%>
		</tr>
		<%
		i++;
		}
		%>

	</table>
	<%
	if (session == null || session.getAttribute("userNum") == null || session.getAttribute("userNum").equals("")) {
	} else {
	%>
	<br>
	<input type="button" value="글쓰기" onclick="location.href='write.jsp'">
	<%
	}
	%>
</body>
</html>