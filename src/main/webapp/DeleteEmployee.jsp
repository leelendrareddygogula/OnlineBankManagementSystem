<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/" method="get" style="align-items: center;">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Delete Employees</h3>
	<h4 style="color: orange" align="center"><c:out value="${empdelmsg}"></c:out></h4>
	<form action="/admin/deleteemployeerecord" method="post">
		<table align = "center" border="1">
			<tr> 
				<td>Enter Employee ID to Delete: </td>
				<td> <input type="number" value="0" name="deleteemployeeid"> </td>
			</tr>
		</table>
		<input type="submit" class="button" name="Delete Record">
	</form>
	<a href="/admin/addemployee">Add New Employee</a><br/>
	<a href="/admin/deleteemployee">Delete Another Employee?</a><br/>
	<a href="/admin/updateemployee">Update Employee Details</a><br/>
	<a href="/admin/getallemployeedetails">Get All Employee Details</a><br/>
	<a href="/adminhome">Admin Home</a><br/>
	<a href="/admin/dashboard">Admin Dashboard</a><br/>
</body>
</html>