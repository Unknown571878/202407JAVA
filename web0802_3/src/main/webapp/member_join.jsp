<%@page import="board.MemberDTO"%>
<%@page import="board.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
	MemberDAO dao = new MemberDAO();

        if (dao.idSearch(request.getParameter("id"))) {   
            // 이미 있는 아이디이면 오류 표시
%>
            <script>
                alert('이미 등록된 아이디입니다.');
                history.back()
            </script>
<%          
        } else {    
        	// 새로운 회원정보를 DB에 추가하는 쿼리      
            dao.addMember(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"));
        
          
%>
            <script>
                alert('가입이 완료되었습니다.');
                window.close();
            </script>
<%          
        }
  
%>

</body>
</html>