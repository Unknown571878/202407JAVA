<%@page import="board.MemberDTO"%>
<%@page import="board.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
	MemberDAO dao = new MemberDAO();

        // 그런 레코드가 있으면, 세션 속성을 등록하고, 메인 화면으로 돌아감
        if (dao.loginMember(request.getParameter("id"), request.getParameter("pw"))) {
        	MemberDTO dto = dao.memberSearch(request.getParameter("id"));
            session.setAttribute("userId",   dto.getId());
            session.setAttribute("userName", dto.getName());
                
            response.sendRedirect("login_main.jsp");   
            return;
        
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>
