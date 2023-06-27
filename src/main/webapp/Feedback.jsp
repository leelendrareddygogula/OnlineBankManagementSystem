<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
</head>
<body>
	<h1 align="center" style="color: red">Online Bank Management System</h1>
	<form action="/home" method="get">
		<input type="submit" value="LogOut">
	</form>
	<hr color="blue"/><hr color="blue"/>
	<h3 align="center" style="color: orange">Please click on below form for providing feedback</h3>
	
	<h1 align="center">
		<button onclick="NewTab()">
	        Click for Feed Back Form
	    </button>
	</h1>
 
    <script>
        function NewTab() 
        {
            window.open("https://forms.gle/bnbkekrqutVQfApk8", "_blank");
        }
    </script>
    
    <a href="/checkcustomerlogin">Customer Login</a><br/>
	<a href="/checkadminlogin">Admin Login</a><br/>
	<a href="/checkemployeelogin">Employee Login</a><br/>
	<a href="/helpdesk">Help Desk</a><br/>
	<a href="/home">Home</a><br/>
</body>
</html>