<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
String balanceTmp = "";
String sql = "";

request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String id = request.getParameter("id");
String balance = request.getParameter("balance");
String delname = request.getParameter("delname");
String delssn = request.getParameter("delssn");

	if(id !=null && balance != null){
		int userbal = Integer.parseInt(balanceTmp);
		int insertbal = Integer.parseInt(balance);
		int sum = userbal + insertbal;
		sql = "update account set balance = ? where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sum);
		pstmt.setString(2, id);
		int ret = pstmt.executeUpdate();
	}
	if (delname != null && delssn != null){
		sql = "delete from score where num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delname);
		int ret = pstmt.executeUpdate();
	}
	if(name != null && ssn != null && tel != null){
		sql = "insert into account(name, ssn, tel, balance) values (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, "0");
		int ret = pstmt.executeUpdate();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	width: 800px;
	text-align: left;
}

th {
	width: 40px;
	background-color: cyan;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<form>
		이름: <input type="text" name="name"> &emsp;&emsp; ID: <input type="text" name="ID">&emsp;&emsp; ID: <input type="text" name="delname"><br>
		SSN: <input type="text" name="ssn"> &emsp; 입금/출금: <input type="text" name="balance">&emsp; SSN: <input type="text" name="delssn"><br>
		TEL: <input type="text" name="tel"><br> 
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<input type="submit" value="입력">
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<input type="submit" value="입금/출금">
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;
			<input type="submit" value="삭제"><br>
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SSN</th>
			<th>TEL</th>
			<th>BALANCE</th>
		</tr>
		<%
		sql = "select * from account";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			idTmp = rs.getString("id");
			nameTmp = rs.getString("name");
			ssnTmp = rs.getString("ssn");
			telTmp = rs.getString("tel");
			balanceTmp = rs.getString("balance");
		%>
		<tr>
			<td><%=idTmp%></td>
			<td><%=nameTmp%></td>
			<td><%=ssnTmp%></td>
			<td><%=telTmp%></td>
			<td><%=balanceTmp%></td>
		</tr>
		<%
		}
		%>
		<tr>
			<td></td>
		</tr>
	</table>
</body>
</html>