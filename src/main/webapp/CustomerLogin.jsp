<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<a href="/" style="align-items: center">Home</a>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Customer Login</h3>
	<a href="/home">Home</a>
	<form action="/customer" method="post">
		<h3 style="color: red;" align="center"><c:out value="${errormess}"></c:out> </h3>
		<table align="center">
			<tr>
				<td>Enter customerID: </td>
				<td> <input type="number" name="logincustomerid" required="required"></td>
			</tr>
			<tr>
				<td>Enter your password: </td>
				<td> <input type="password" name="logincustomerpassword" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Login" > </td>
			</tr>
		</table>
	</form>
</body>
</html>