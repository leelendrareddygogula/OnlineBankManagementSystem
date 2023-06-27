<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Transaction</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Hey <c:out value="${c.name}"></c:out> , Enter Details To Make a Transaction</h3>
	
	<form action= '<c:url value="/customer/transaction?custid=${c.customerId}"></c:url>' method="post">
		<table align="center" border="1">
			<tr>
				<td>Your transaction will be done from</td>
				<td> <input type="number" value="${fromaccount}" name="fromtransfer" readonly="readonly" required="required"> </td>
			</tr>
			<tr>
				<td>Transfer Amount To</td>
				<td> <input type="number" required="required" name="totransfer"> </td>
			</tr>
			<tr>
				<td>Enter Amount to Transfer</td>
				<td> <input type="text" required="required" name="amountfortrans"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Make Transaction"> </td>
			</tr>
		</table>
	</form>
	
	<a href='<c:url value="/customer/home?custid=${c.customerId}"></c:url>'>Home</a>
	
</body>
</html>