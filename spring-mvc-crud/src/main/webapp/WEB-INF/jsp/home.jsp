<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h3 style="color: green">${message}</h3>
		<form:form action="saveProduct" modelAttribute="product">
			<form:label path="id">ProductId</form:label><br>
			<form:input type="number" path="id" placeholder="enter product id"/><br>
			
			<form:label path="name">ProductName</form:label><br>
			<form:input type="text" path="name" placeholder="enter product id"/><br>
			
			<form:label path="color">ProductColor</form:label><br>
			<form:input path="color" placeholder="enter product color"/><br>
			
			<form:label path="price">ProductPrice</form:label><br>
			<form:input type="number" path="price" placeholder="enter product price"/><br>
			
			<input type="submit" value="submit"/>
			
		</form:form>
</body>
</html>