<%-- 
    Document   : index2
    Created on : Nov 29, 2016, 9:04:39 AM
    Author     : Jorda
--%>
<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>

<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
</head>


	<ul>
		<li><a href="login.jsp"> <img border="0" alt="VersusDB"
				src="VersusDBLogo.png" width="222" height="35">
		</a></li>
		<li><a class="active" href="index.html">Home</a></li>
		<li><a href="matches.html">Matches</a></li>
		<li><a href="teams.html">Teams</a></li>
		<li><a href="profile.jsp">Profile</a></li>
		<li><a href="about.html">About</a></li>
	</ul>
    
        <%
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    userName = cookie.getValue();
                }
            }
            if (userName == null)
                response.sendRedirect("login.jsp");
        %>

	<div id="centerDoc"> 
		<h1>Welcome to VersusDB</h1> 
		<h2> This web site allows you to create an account, join teams, and play and record matches.</h2>
		
                <p>You are currently signed in as: <a href="profile.jsp"><%=userName%></a>
		<br></p>
		
		<img class = "resize" src = "Versus.png">
		<br> <br> <br> <br>
		<button>Log Out</button>
		
	</div>

