<%@page import="shop.Product"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
ProductDAO dao = new ProductDAO();
Product product = dao.getProductById(id);
request.setAttribute("products", product);
%>
<jsp:forward page="updateproduct_view.jsp"/>

