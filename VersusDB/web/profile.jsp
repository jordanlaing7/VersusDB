<%-- 
    Document   : profile
    Created on : Nov 29, 2016, 9:16:33 AM
    Author     : Jorda
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

    <ul>
            <li><a href="login.jsp"> <img border="0" alt="VersusDB"
                            src="VersusDBLogo.png" width="222" height="35">
            </a></li>
            <li><a class="active" href="index.jsp">Home</a></li>
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
    %>
    
    <div id="centerDoc">
        <form style="border:none" action="ProfileServlet" method="get">
            <h1>Profile</h1>
            <h2 class = "h2"> Name:</h2>
            <%
                String fname = null;
                String lname = null;
                String name = null;
                String team = null;
                int id = 0;
                if(session.getAttribute("fname") != null)
                {
                    fname = (String)session.getAttribute("fname");
                    lname = (String)session.getAttribute("lname");
                    name = fname + " " + lname;
                    team = (String)session.getAttribute("team");
                    id = (int)session.getAttribute("id");
                    
                }
                    
            %>
            <p><%=name%></p>
                <br>
            <h2 class = "h2"> Username:</h2>
            <p id="id2"><%=userName%></p> <br>
            <h2 class = "h2"> Team:</h2>
            <p id="id3"><%=team%></p> <br>
            <h2 class = "h2"> Id</h2>
            <p id="id4"><%=id%></p> <br>
        </form>
    </div>

</body>
</html>