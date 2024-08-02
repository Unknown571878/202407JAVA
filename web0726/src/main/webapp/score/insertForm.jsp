<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 점수 입력</title>
</head>
<body>
	<form action="insertResult.jsp">
		학번: <input name="user"><br>
		이름: <input name="name"><br>
		국어: <input name="kor"><br>
		영어: <input name="eng"><br>
		수학: <input name="math"><br>
		<input type="submit" value="보내기">
	</form>
</body>
</html>