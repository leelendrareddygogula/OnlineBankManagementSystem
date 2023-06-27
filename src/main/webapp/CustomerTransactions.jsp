<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Transactions</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Hey <c:out value="${c.name}"></c:out>, Here are All Your Transactions</h3>
	
	<table align="center" border="4">
		<tr>
			<th>Transaction ID</th>
			<th>Transaction Done From Acccount</th>
			<th>Transaction Done To Account</th>
			<th>Transaction Amount</th>
		</tr>
		<c:forEach items="${transactions}" var="t">
			<tr>
				<td> <c:out value="${t.transactionId}"></c:out> </td>
				<td> <c:out value="${t.transcationFrom}"></c:out> </td>
				<td> <c:out value="${t.transactionTo}"></c:out> </td>
				<td> <c:out value="${t.transactionAmount}"></c:out> </td>
			</tr>
		</c:forEach>
	</table>
	
	<a href='<c:url value="/customer/home?custid=${c.customerId}"></c:url>'>Home</a><br/>
	<a href='<c:url value="/customer/updatecustomerpassword?custid=${c.customerId}"></c:url>'>Update Your Password?</a><br/>
	<a href='<c:url value="/customer/maketransaction?custid=${c.customerId}"></c:url>'>Make A Transaction</a>
</body>
</html>