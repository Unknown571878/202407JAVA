<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empJsonserver1.jsp" method="post">
<input type="hidden" name="action" value="create">
ename: <input type="text" value="" name="ename"><br>
job: <input type="text" value="" name="job"><br>
mrg: <input type="text" value="" name="mgr"><br>
hiredate: <input type="text" value="" name="hiredate"><br>
sal: <input type="text" value="" name="sal"><br>
comm: <input type="text" value="" name="comm"><br>
deptno: <input type="text" value="" name="deptno"><br>
<button>삽입</button>
</form>
</body>
</html>