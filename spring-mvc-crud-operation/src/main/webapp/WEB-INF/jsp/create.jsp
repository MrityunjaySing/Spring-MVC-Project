<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<f:form action="register" modelAttribute="employee">
		<f:label path="id">EmployeeId</f:label>
		<f:input path="id" />

		<f:label path="name">EmployeeName</f:label>
		<f:input path="name" />

		<f:label path="email">EmployeeEmail</f:label>
		<f:input path="email" />

		<input type="submit" value="Submit">
	</f:form>

	<div>
		<a href="/spring-mvc-crud-operation">
			<button>View Employees</button>
		</a>
	</div>
</body>
</html>