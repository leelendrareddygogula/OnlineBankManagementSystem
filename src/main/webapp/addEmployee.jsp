<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/" method="get" style="align-items: center;">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h2 align="center" style="color: orange">Add New Employee</h2>
	<h3 align="center" style="color: yellow"><c:out value="${message}"></c:out> </h3>
	<table align = "center" border="1">
		<form:form action="/admin/addnewemployee" method="post" modelAttribute="employee">
		<tr>
			<td>Enter the Name of Employee</td>
			<td><form:input path="name" required="required"/> <br class="clear"></td>
		</tr>
		<tr>
			<td>Enter the City of Employee</td>
			<td><form:input path="city" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Door No. of Employee</td>
			<td><form:input path="doorNo" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Land Mark of Employee</td>
			<td><form:input path="landmark" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Pincode of Employee</td>
			<td><form:input path="pincode" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Aadhar Number of Employee</td>
			<td><form:input path="aadharNumber" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Pan Card Number of Employee</td>
			<td><form:input path="panCardNumber" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Contact Number of Employee</td>
			<td><form:input path="contactNumber" required="required" /></td>
		</tr>
		<tr>
			<td>Enter the Password of Employee</td>
			<td><form:password path="password" required="required" /></td>
		</tr>
		<tr>
			<td>Select Gender: </td>
			<td>
				<form:radiobutton path="gender" value="male" label="MALE" required = "required"/><br/>
				<form:radiobutton path="gender" value="female" label="FEMALE" required = "required"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add Employee" class="button"/> </td>
		</tr>
		</form:form>
	</table>
	<a href="/admin/addemployee">Add Another Employee?</a><br/>
	<a href="/admin/deleteemployee">Delete an Employee</a><br/>
	<a href="/admin/updateemployee">Update Employee Details</a><br/>
	<a href="/admin/getallemployeedetails">Get All Employee Details</a><br/>
	<a href="/adminhome">Admin Home</a><br/>
</body>
</html>