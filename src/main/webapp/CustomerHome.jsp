<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Home</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Hey <c:out value="${c.name}"></c:out> , Good to See You Today</h3>
	
	<table align="center" border="1">
		<tr>
			<td>Your Customer ID: </td>
			<td> <input type="number" value="${c.customerId}" readonly="readonly"> </td>
		</tr>
	</table>
	<a href='<c:url value="/customer/transactions?custid=${c.customerId}"></c:url>'>Get Your Transactions</a><br/>
	<a href='<c:url value="/customer/updatecustomerpassword?custid=${c.customerId}"></c:url>'>Update Your Password?</a><br/>
	<a href='<c:url value="/customer/maketransaction?custid=${c.customerId}"></c:url>'>Make A Transaction</a>
</body>
</html>