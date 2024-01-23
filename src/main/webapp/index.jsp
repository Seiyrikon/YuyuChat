<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<html>
<head>
    <title>Welcome</title>
    <link rel="icon" href="resources/derpy-man.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
    <!-- You can add content here if needed -->
    <%@ include file="/pages/common/top-nav/TopNavigation.jsp" %>
    
    <%
    // Get the current session and invalidate it (log out the user)
    HttpSession currentSession = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }

	%>
    <div id="content-container"></div>
</body>
</html>
