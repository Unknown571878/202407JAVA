<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String num = request.getParameter("deptno");
    String URL = "jdbc:mysql://localhost:3307/spring5fs";
    Connection conn = null;
    PreparedStatement pstmt = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<body>
<table>
<tr>
<th class="num">JSON</th>


</tr>
<%
String sql = "select json_object('empno', empno, 'ename', ename, 'job', job, 'sal', sal) from emp;";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

while(rs.next()){
	String data = rs.getString(1);
	%>
	<tr>
	<td><%=data %></td>
	</tr>
<% } %>
	</table>
	<hr>
	<script type="text/javascript">
	function callEmp(deptno) {
	}
	</script>
</body>
</html>