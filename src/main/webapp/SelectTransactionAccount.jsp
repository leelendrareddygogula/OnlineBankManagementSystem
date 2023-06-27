<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Account</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Hey <c:out value="${c.name}"></c:out> Select Your account to make transactions</h3>
	
	<form action= '<c:url value="/customer/entertransactiondetails?custid=${c.customerId}"></c:url>' method="post">
		<table align="center" border="1">
			<tr>
				<td>Select one of your account</td>
				<td>
					<select name="acnum" required="required">
							<option value="-1">---Select---</option>
						<c:forEach items="${accounts}" var="a">
							<option value="${a.accountNumber}"> <c:out value="${a.accountNumber}"></c:out> </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Enter Details"></td>
			</tr>
		</table>
	</form>
	<a href='<c:url value="/customer/transactions?custid=${c.customerId}"></c:url>'>Get Your Transactions</a><br/>
	<a href='<c:url value="/customer/home?custid=${c.customerId}"></c:url>'>Home</a><br/>
	<a href='<c:url value="/customer/updatecustomerpassword?custid=${c.customerId}"></c:url>'>Update Your Password?</a><br/>
</body>
</html>