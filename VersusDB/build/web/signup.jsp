<%-- 
    Document   : signup
    Created on : Nov 29, 2016, 11:45:43 AM
    Author     : Jorda
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<ul>
		<li><a href="login.html"> <img border="0" alt="VersusDB"
				src="VersusDBLogo.png" width="222" height="35">
		</a></li>
		<li><a class="active" href="index.html">Home</a></li>
		<li><a href="matches.html">Matches</a></li>
		<li><a href="teams.html">Teams</a></li>
		<li><a href="profile.html">Profile</a></li>
		<li><a href="about.html">About</a></li>
	</ul>
	
	<div
		style="padding: 50px; margin-top: 30px; background-color: #DDD; height: 1500px;">
		<div class="container">
                    <form style="border:none" action="SignupServlet" method="post">
			<h1>Create A Player Account</h1>
			<h2>Here, you can create a Player account on our web site. Please enter your information below.</h2>
			<label><b>Enter first name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label> <input id="fname" type="text"
				placeholder="Enter first name" name="fname" required><p></p>
                        <label><b>Enter last name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label> <input id="lname" type="text"
				placeholder="Enter last name" name="lname" required><p></p>
			<label><b>Enter desired Username</b></label> <input id="id1" type="text"
				placeholder="Enter Username" name="username" required> 
			<p id="error1"></p> <br>
                        <label><b>Enter email address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label> <input id="id1" type="email"
                                placeholder="Enter email" name="email" required><br> 
			<label><b>Enter desired Password&nbsp;</b></label> <input id="id2" type="password"
				placeholder="Enter Password" name="password" required>
			<p id="error2"></p> <br>
			<label><b>Enter Password again&nbsp;&nbsp;&nbsp;&nbsp;</b></label> <input id="id3" type="password"
				placeholder="Enter Password Again" name="psw" required> <br>
                        <br>	
			<input type="submit" value="Create Account">
                    </form>

<script>
function check(){
	var obj = document.getElementById("id1").value;
	if(obj === "")
		document.getElementById("error1").innerHTML = "Username not valid. Try again.";
	else
		document.getElementById("error1").innerHTML = "Username taken. Try again.";
	obj2 = document.getElementById("id2").value;
	obj3 = document.getElementById("id3").value;
	if(obj2 === "" || obj3 === ""){
		document.getElementById("error2").innerHTML = "Password not valid. Try again.";
		return false;
	}	
	if(obj2.valueOf() != obj3.valueOf())
		document.getElementById("error2").innerHTML = "Passwords do not match. Try again.";
}
</script>
		</div>
	</div>
</body>
