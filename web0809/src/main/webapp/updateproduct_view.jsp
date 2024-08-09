<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body>

	<form action="updateproduct.jsp?id=${products.id}" method="post">
		<div>
			<label for="name">제품명:</label> <input type="text" id="name"
				name="name" value="${products.name}" required>
		</div>
		<div>
			<label for="description">설명:</label>
			<textarea id="description" name="description" required>${products.description}</textarea>
		</div>
		<div>
			<label for="price">가격:</label> <input type="text" id="price"
				name="price" value="${products.price}" required>
		</div>
		<div>
			<label for="stock">수량:</label> <input type="text" id="stock"
				name="stock" value="${products.stock}" required>
		</div>
		<div>
			<input type="submit" value="Add Product">
		</div>
	</form>
</body>
</html>