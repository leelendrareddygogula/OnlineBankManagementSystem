<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Hey <c:out value="${c.name}"></c:out> , Enter Current and New Password to update password</h3>
	
	<form action='<c:url value="/customer/changepassword?custid=${c.customerId}"></c:url>' method="post">
		<table align="center" border="1">
		<tr>
			<td>Your Customer ID</td>
			<td> <c:out value="${c.customerId}"></c:out> </td>
		</tr>
		<tr>
			<td>Enter Your Current Password</td>
			<td> <input type="password" required="required" name="currpwd"> </td>
		</tr>
		<tr>
			<td>Enter Your New Password</td>
			<td> <input type="password" required="required" name="newpwd"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"> <input type="submit" value="change password"> </td>
		</tr>
	</table>
	</form>
	<a href='<c:url value="/customer/home?custid=${c.customerId}"></c:url>'>Home</a><br/>
	<a href='<c:url value="/customer/transactions?custid=${c.customerId}"></c:url>'>Get Your Transactions</a><br/>
	<a href='<c:url value="/customer/maketransaction?custid=${c.customerId}"></c:url>'>Make A Transaction</a>
</body>
</html>