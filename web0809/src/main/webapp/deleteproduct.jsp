<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ProductDAO dao = new ProductDAO();
    int id = Integer.parseInt(request.getParameter("id")); 
    dao.deleteProduct(id);
    response.sendRedirect("products.jsp");
    %>
