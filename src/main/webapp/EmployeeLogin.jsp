<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<a href="/" style="align-items: center">Home</a>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Employee Login</h3>
	<h4 align="center" style="color: yellow"><c:out value="${emploginfail}"></c:out></h4>
	<form action="/employee" method="post">
		<table border="1" align = "center">
			<tr>
				<td>Enter ID: </td>
				<td><input type="number" required="required" name="employeeloginid"></td>
			</tr>
			<tr>
				<td>Enter Password: </td>
				<td><input type="password" required="required" name="employeeloginpassword"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>