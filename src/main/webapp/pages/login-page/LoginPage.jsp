<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="pages/login-page/LoginPage.css">
</head>
<body>
<%@ include file="/pages/common/top-nav/TopNavigation.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <div class="content-container">
        <html:form action="/login" method="post" styleId="loginForm">
            <!-- Your form fields -->
            <label for="username">Username:</label>
            <html:text property="username" styleId="username" />

            <label for="password">Password:</label>
            <html:password property="password" styleId="password" />

            <html:submit value="Login" />
        </html:form>
    </div>

</body>
</html>