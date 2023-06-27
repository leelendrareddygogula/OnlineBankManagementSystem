<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Account</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">New Customer Account, Account Details</h3>
	<h2 align="center" style="color: navy;"><c:out value="${accountcreation}"></c:out></h2>
	<form action="/employee/customeraccountdetails" method="post">
		<table align = "center" border="1">
			<tr> 
				<td>Enter Branch Name: </td>
				<td> <input type="text" name="branchname" required="required"> </td>
			</tr>
			<tr> 
				<td>Enter Opening Balance:</td>
				<td> <input type="text" name="openbalance" required="required"> </td>
			</tr>
			<tr> 
				<td>Customer's customerId is: </td>
				<td> <input type="number" name="customerid" required="required" value="${custID}" readonly="readonly"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Create Account"> </td>
			</tr>
		</table>
	</form>
	<!-- <a href="/employee/home">Home</a><br/> -->
</body>
</html>