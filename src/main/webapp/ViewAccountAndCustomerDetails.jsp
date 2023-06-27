<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer and Account Details</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Customer and Account Details</h3>
	<form action="/employee/customerandaccountdetailslist" method="post">
	<h3 align="center" style="color: purple;"><c:out value="${invlmsg}"></c:out></h3>
		<table>
			<tr>
				<td>Enter the Customer ID: </td>
				<td> <input type="number" name="customergetid" required="required"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="submit"> </td>
			</tr>
		</table>
	</form>
	<a href="/employee/newcutomeraccount/customerdetails">Create Account?</a><br/>
	<a href="/employee/changepassword">Change Password</a><br/>
	<a href="/employee/home">Employee Home</a><br/>
</body>
</html>