<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Customer Account Messages</h3>
	<h2 align="center" style="color: navy;"><c:out value="${accountcreation}"></c:out></h2>
	<a href="/employee/newcutomeraccount/customerdetails">Create Another Account?</a><br/>
	<a href="/employee/changepassword">Change Password</a><br/>
	<a href="/employee/home">Employee Home</a><br/>
	<a href="/employee/newaccountforcustomer">Create Only Account for existing customer</a><br/>
</body>
</html>