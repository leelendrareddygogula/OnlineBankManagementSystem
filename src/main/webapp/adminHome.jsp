<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
	<h1 align="center" style="color:red">Online Bank Management System</h1>
	<form action="/" method="get" style="align-content: center">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h2 align="center" style="color: orange">Welcome, Administrator</h2>
	<a href="/admin/addemployee">Add New Employee</a><br/>
	<a href="/admin/deleteemployee">Delete an Employee</a><br/>
	<a href="/admin/updateemployee">Update Employee Details</a><br/>
	<a href="/admin/getallemployeedetails">Get All Employee Details</a><br/>
	<a href="/admin/dashboard">Admin Dashboard</a><br/>
</body>
</html>