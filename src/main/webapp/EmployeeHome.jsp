<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Employee Home!</h3>
	<a href= '<c:url value = '/employee/changepassword'></c:url>'>Change Password</a><br/>
	<a href="/employee/newcutomeraccount/customerdetails">Create New Customer and Account for Customer</a><br/>
	<a href="/employee/newaccountforcustomer">Create Only Account for existing customer</a><br/>
	<a href="/employee/getcustomerdetails">Account and Customer Details</a><br/>
	<a href="/employee/maketransaction">Make A Transaction</a><br/>
	<a href="/employee/addordeductfunds">Add or Reduce Funds</a><br/>
</body>
</html>