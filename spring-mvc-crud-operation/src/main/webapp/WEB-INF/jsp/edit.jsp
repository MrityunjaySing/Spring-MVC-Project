<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Employee ${employee.id}</h1>

	<f:form modelAttribute="employee" method="post" action="/edit">
		<f:label path="id">EmployeeId</f:label>
		<f:input path="id" value="${employee.id}" />

		<f:label path="name">EmployeeName</f:label>
		<f:input path="name" value="${ employee.name}" />

		<f:label path="email">EmployeeEmail</f:label>
		<f:input path="email" value="${ employee.email}" /> 
		
		<input type="submit" value="Submit">
	</f:form>
</body>
</html>