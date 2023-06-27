<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/" method="get" style="align-items: center;">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">All Employees</h3>
	<br/>
	<table border="1" align = "center" >
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>City</th>
			<th>Door Number</th>
			<th>Landmark</th>
			<th>Pincode</th>
			<th>Contact Number</th>
			<th>Aadhar Number</th>
			<th>Pan Number</th>
		</tr>
		
		<c:forEach items="${employees}" var="e">
			<tr>
				<td> <c:out value="${e.employeeId}"></c:out> </td>
				<td> <c:out value="${e.name}"></c:out> </td>
				<td> <c:out value="${e.gender}"></c:out> </td>
				<td> <c:out value="${e.city}"></c:out> </td>
				<td> <c:out value="${e.doorNo}"></c:out> </td>
				<td> <c:out value="${e.landmark}"></c:out> </td>
				<td> <c:out value="${e.pincode}"></c:out> </td>
				<td> <c:out value="${e.contactNumber}"></c:out> </td>
				<td> <c:out value="${e.aadharNumber}"></c:out> </td>
				<td> <c:out value="${e.panCardNumber}"></c:out> </td>
			</tr>
		</c:forEach>
		</table>
	
	<a href="/admin/addemployee">Add Employee</a><br/>
	<a href="/admin/deleteemployee">Delete an Employee</a><br/>
	<a href="/admin/updateemployee">Update Employee Details</a><br/>
	<a href="/adminhome">Admin Home</a><br/>
	<a href="/admin/dashboard">Admin Dashboard</a><br/>
</body>
</html>