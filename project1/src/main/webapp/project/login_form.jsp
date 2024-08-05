<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login_action.jsp" method="post"> 
            아이디:   <input type="text"     name="id"><br>
            ssn: <input type="password" name="ssn"><br>
            <input type="submit" value="로그인">
            <input type="button" value="회원가입" 
                   onclick="window.open('member_join_form.jsp', 'popup', 
                                        'width=400, height=200')">
        </form>
</body>
</html>