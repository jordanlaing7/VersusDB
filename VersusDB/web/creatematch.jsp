<%-- 
    Document   : creatematch
    Created on : Nov 29, 2016, 12:39:31 AM
    Author     : Jorda
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matches</title>
<link rel="stylesheet" href="request.css">
</head>
<body>

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

	<div>
		<br><br><br>
		<h1>Create A Match</h1>
		<div>
		  	<form style="border:none" action="CreateMatchServlet" method="post">
			    <label for="act">Activity</label>
			    <input type="text" id="act" name="activity">
			    <p></p>
			    
				<label for="team1">Team 1 Name</label>
				<input type="text" id="team1" name="team1">
				<p></p>
				
				<label for="team2">Team 2 Name</label>
				<input type="text" id="team2" name="team2">
				<p></p>
				
				<label for="loc">Location of Match</label>	
			    <input type="text" id="loc" name="location">
			    <p></p>
			    
			    <label for="date">Date of Match&nbsp;&nbsp;&nbsp;</label>
			    <input type="date" id="date" name="date" >
			    
			    <label for="time">&nbsp;&nbsp;&nbsp;Time of Match&nbsp;&nbsp;&nbsp;</label>
			    <input type="time" id="time" name="time" >
			  	<br><br>
                            <input type="submit" value="Create Match">
		  	</form>
		</div>
		
<!--		<script>
			function clicked() {
				confirm("Are you sure you want to create this match?"
						+ " Once you press yes, the match will be "
		    			+ "scheduled and every member of both teams"
		    			+ " will be notified.");
			}
		
		</script>-->
		
		
	</div>

</body>
</html>
