<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Admin Dashboard</h3>
	
	<table align="center" border="1">
		<tr>
			<th align="center">Total Numbers of Employees Available</th>
			<th align="center">Total Numbers of Customers</th>
			<th align="center">Total Numbers of Accounts existing for Customer</th>
			<th align="center">Total Count of Transactions Made</th>
		</tr>
		<tr>
			<td align="center">${employeecount}</td>
			<td align="center">${customerscount}</td>
			<td align="center">${accountscount}</td>
			<td align="center">${transactionscount}</td>
		</tr>
	</table>
	
	<a href="/adminhome">Admin Home</a><br/>
	<a href="/admin/addemployee">Add New Employee</a><br/>
	<a href="/admin/deleteemployee">Delete an Employee</a><br/>
	<a href="/admin/updateemployee">Update Employee Details</a><br/>
	<a href="/admin/getallemployeedetails">Get All Employee Details</a><br/>
</body>
</html>