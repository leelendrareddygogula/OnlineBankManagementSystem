<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Status</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Status of Transaction</h3>
	<h2 style="color: teal;" align="center"> <c:out value="${transactionmsg}"></c:out> </h2>
	<a href="/employee/home">Home</a><br/>
	<a href="/employee/newcutomeraccount/customerdetails">Create New Customer and Account for Customer</a><br/>
	<a href="/employee/newaccountforcustomer">Create Only Account for existing customer</a><br/>
	<a href="/employee/getcustomerdetails">Account and Customer Details</a><br/>
	<a href="/employee/maketransaction">Make another Transaction?</a>
</body>
</html>