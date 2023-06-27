<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Funds To Customer Account</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Credit or Debit Funds</h3>
	<h2 align="center" style="color: fuchsia;"> <c:out value="${transactionmsg}"></c:out> </h2>
	<form action="/employee/crdrfunds" method="post">
		<table>
			<tr>
				<td>Select Operation</td>
				<td>
					<select name="operation">
						<option value="-1">---Select---</option>
						<option value="credit">Credit</option>
						<option value="debit">Debit</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Chose Account Number of Customer</td>
				<td>
					<select name="accountnumber" required="required">
						<option value="-1">---Select---</option>
						<c:forEach items="${accounts}" var="a">
							<option value="${a.accountNumber}">${a.accountNumber}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Enter Amount</td>
				<td> <input type="text" required="required" name="amount"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center" > <input type="submit" value="submit"> </td>
			</tr>
		</table>
	</form>
	<a href="/employee/home">Employee home</a><br/>
	<a href= '<c:url value = '/employee/changepassword'></c:url>'>Change Password</a><br/>
	<a href="/employee/newcutomeraccount/customerdetails">Create New Customer and Account for Customer</a><br/>
	<a href="/employee/newaccountforcustomer">Create Only Account for existing customer</a><br/>
	<a href="/employee/getcustomerdetails">Account and Customer Details</a><br/>
	<a href="/employee/maketransaction">Make A Transaction</a><br/>
	
</body>
</html>