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
<title>Matches</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<ul>
		<li><a href="index.html"> <img border="0" alt="VersusDB"
				src="VersusDBLogo.png" width="222" height="35">
		</a></li>
		<li><a class="active" href="index.html">Home</a></li>
		<li><a href="matches.html">Matches</a></li>
		<li><a href="teams.html">Teams</a></li>
		<li><a href="profile.jsp">Profile</a></li>
		<li><a href="about.html">About</a></li>
	</ul>

	<div id="centerDoc">
		<h1>Ranked Matches</h1>
		<p>
		<a id="cap1" href="rankedrequest.html">Request Ranked Match</a><br>
		<a id="cap2" href="rankedaccept.html">Accept Ranked Match</a><br>
		<a id="ref1" href="pendingranked.html">Pending Ranked Matches</a><br>
		<a id="ref2" href="creatematch.jsp">Create Ranked Match</a>
		</p>
		<p style="font-size: 1.5em;">List of Scheduled Ranked Matches:</p>
		
		<a href="RankedServlet">List of scheduled ranked matches</a>
                
                
	</div>	

<!--<script>
function hideCap() {
	var cap1 = document.getElementById("cap1");
	var cap2 = document.getElementById("cap2");
	cap1.style.display = "none";
	cap2.style.display = "none";
}
function hideRef() {
	var ref1 = document.getElementById("ref1");
	var ref2 = document.getElementById("ref2");
	ref1.style.display = "none";
	ref2.style.display = "none";
}
//hideCap(); /* FOR HIDING LINKS */
//hideRef();

</script>-->

</body>
</html>
