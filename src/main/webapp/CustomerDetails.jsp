<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">New Customer Account, Customer Details</h3>
	<h4 align="center" style="color: yellow"> <c:out value="${customerdetailserrmsg}"></c:out> </h4>
	<form:form action="/employee/newcutomeraccount/customeraccount" method="post" modelAttribute="customerdetails">
		<table align = "center" border="1">
			<tr>
				<td>Enter Name of the Customer: </td>
				<td><form:input path="name" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter City of the Customer: </td>
				<td><form:input path="city" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter door number of the Customer: </td>
				<td><form:input path="doorNo" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Landmark of the Customer: </td>
				<td><form:input path="landmark" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Pin Code of the Customer: </td>
				<td><form:input path="pincode" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Aadhar Number of the Customer: </td>
				<td><form:input path="aadharNumber" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Pan Card Number of the Customer: </td>
				<td><form:input path="panCardNumber" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Contact Number of the Customer: </td>
				<td><form:input path="contactNumber" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Password of the Customer: </td>
				<td><form:password path="password" required = "required"/></td>
			</tr>
			<tr>
				<td>Enter Gender of the Customer: </td>
				<td>
					<form:radiobutton path="gender" value="male" required = "required"/>Male
					<form:radiobutton path="gender" value="female" required = "required"/>Female
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form:form>
	<a href="/employee/home">Employee home</a><br/>
	<a href= '<c:url value = '/employee/changepassword'></c:url>'>Change Password</a><br/>
	<a href="/employee/newaccountforcustomer">Create Only Account for existing customer</a><br/>
	<a href="/employee/getcustomerdetails">Account and Customer Details</a><br/>
	<a href="/employee/maketransaction">Make A Transaction</a><br/>
	<a href="/employee/addordeductfunds">Add or Reduce Funds</a><br/>
</body>
</html>