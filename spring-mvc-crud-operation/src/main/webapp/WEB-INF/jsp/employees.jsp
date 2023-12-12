<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Employees List</h1>
<a href="./create"><button>Create Employee</button></a>
 <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>
                	<div>
                		<a href="./edit/${employee.id}"><button>Edit</button></a>
                		<button style="background-color: red; color: white; ">Delete</button>
                	</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>