<%-- 
    Document   : login
    Created on : Nov 29, 2016, 12:03:12 AM
    Author     : Jorda
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <ul>
            <li><a href="index.jsp"> <img border="0" alt="VersusDB"
                            src="VersusDBLogo.png" width="222" height="35">
            </a></li>
            <li><a class="active" href="index.html">Home</a></li>
            <li><a href="matches.html">Matches</a></li>
            <li><a href="teams.html">Teams</a></li>
            <li><a href="profile.jsp">Profile</a></li>
            <li><a href="about.html">About</a></li>
    </ul>


    <div
        style="padding: 50px; margin-top: 30px; background-color: #DDD; height: 1500px;">
        <div class="container">
            <form action="LoginServlet" method="post">
                <label><b>Username</b></label> <input id="id1" type="text"
                        placeholder="Enter Username" name="username" required> <br>
                                    
                <p id="error1"></p><br>
                
                <label><b>Password</b></label> <input id="id2" type="password"
                        placeholder="Enter Password" name="password" required> <br>
                <p id="error2"></p><br>
                <input type="submit" value="Login">
            </form>
            
            
            
            
<!--        <script>
            function check(){
                    var obj = document.getElementById("id1").value;
                    var obj2 = document.getElementById("id2").value;
                    if(obj === "")
                            document.getElementById("error1").innerHTML = "Username field cannot be empty. Try again.";
                    else if(obj2 === "")
                            document.getElementById("error2").innerHTML = "Password field cannot be empty. Try again.";
                    else
                            document.getElementById("error1").innerHTML = "Invalid username or password. Try again.";
            }
        </script>-->

                    <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container" style="background-color: #f1f1f1">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <span class="psw"><a href="#">Forgot password?</a></span>
            </div>
    </div>
</body>
</html>
