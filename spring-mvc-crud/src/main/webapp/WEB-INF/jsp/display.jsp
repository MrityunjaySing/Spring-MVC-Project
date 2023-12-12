<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2px">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="product" items="${productData}">

			<tr>
				<td>${product.getId()}</td>
				<td>${product.getName()}</td>
				<td>${product.getColor()}</td>
				<td>${product.getPrice()}</td>
				<td><a href="deleteProduct?id=${product.getId()}"><button style="background-color: red">DELETE</button></a></td>
				<td><a href="updateProduct?id=${product.getId()}"><button style="background-color: green">UPDATE</button></a></td>

			</tr>

		</c:forEach>



	</table>
</body>
</html>