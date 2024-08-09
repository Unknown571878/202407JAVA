<%@page import="shop.Product"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String description = request.getParameter("description");
double price = Double.parseDouble(request.getParameter("price"));
int stock = Integer.parseInt(request.getParameter("stock"));
ProductDAO productDAO = new ProductDAO();
Product product = new Product(id, name, description, price, stock);
productDAO.updateProduct(product);
response.sendRedirect("products.jsp");
%>