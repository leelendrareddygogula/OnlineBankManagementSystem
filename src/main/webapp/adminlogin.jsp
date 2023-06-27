<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
    <head>
        <title>Admin Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"> -->
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    </head>

    <script>
        $(function(){
          $("#nav-placeholder").load("nav.html");
        });

        function togglePassword() {
            var x = document.getElementById("userpassword");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>
    <style>
        body{
            background-image: url(LoginBg.jpg);
            background-repeat: no-repeat;
            background-size: 100%;
            color: white;
            position: relative;
        }
        input[type="email"]
        {
            outline: none;
            width: 175px;
            border: none;
            height: 30px;
            border-bottom: 2px solid blue;
            background-color: transparent;
            color: white;
        }
        input[type="password"],input[type="text"]
        {
            outline: none;
            width: 150px;
            height: 30px;
            border: none;
            background-color: transparent;
            color: white;
        }
        .passcontainer{
            border-bottom: 2px solid blue;
            width: 175px;
            color: white;
        }
        .container{
            margin-top: 7%;
            margin-left: 7%;
            background-color:  rgb(0 0 0 / 30%);
            padding-top: 5%;
            padding-bottom: 5%;
            margin-right: 60%;
            border-radius: 30px;
        }
        .material-symbols-outlined {
            size: 5px;
        }

        .button-62 {
            background: linear-gradient(to bottom right, #EF4765, #FF9A5A);
            border: 0;
            border-radius: 12px;
            color: #FFFFFF;
            cursor: pointer;
            display: inline-block;
            font-family: -apple-system,system-ui,"Segoe UI",Roboto,Helvetica,Arial,sans-serif;
            font-size: 16px;
            font-weight: 500;
            line-height: 2.5;
            outline: transparent;
            padding: 0 1rem;
            text-align: center;
            text-decoration: none;
            transition: box-shadow .2s ease-in-out;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            white-space: nowrap;
        }

        .button-62:not([disabled]):focus {
            box-shadow: 0 0 .25rem rgba(0, 0, 0, 0.5), -.125rem -.125rem 1rem rgba(239, 71, 101, 0.5), .125rem .125rem 1rem rgba(255, 154, 90, 0.5);
        }

        .button-62:not([disabled]):hover {
            box-shadow: 0 0 .25rem rgba(0, 0, 0, 0.5), -.125rem -.125rem 1rem rgba(239, 71, 101, 0.5), .125rem .125rem 1rem rgba(255, 154, 90, 0.5);
        }  

        ::placeholder {
            color: white;
        }
    </style>
    <body style="display: inline;">
        <form class="container" action="/admin" method="post">
            <center>
                <h1>Admin Login</h1>
                <a href="/" style="align-items: center" >Home</a>
                <h3 align="center"><c:out value="${adminerrormessage}"></c:out></h3>
                <input type="text" placeholder="username" name="adminusername" required="required"><br/><br/>
                <div class="passcontainer">
                    <input type="password" placeholder="yourpassword" name="adminpassword" id="userpassword" required="required">
                    <i class="fa fa-eye icon" onclick="togglePassword()"></i>
                </div><br/><br/>
                <button class="button-62" role="button">Login <i class="fa fa-sign-in" style="font-size: 15px;"></i></button>
            </center>
        </form>
    </body>
</html>