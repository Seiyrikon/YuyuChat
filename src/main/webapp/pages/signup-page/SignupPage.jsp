<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="pages/signup-page/SignupPage.css">
</head>
<body>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <div id="content-container" class="content-container">
        <html:form action="/signup" method="post" styleId="signUpForm">
            <!-- Your form fields -->
            <label for="username">Username:</label>
            <html:text property="username" styleId="username" />

            <label for="password">Password:</label>
            <html:password property="password" styleId="password" />

            <label for="firstName">First Name:</label>
            <html:text property="firstName" styleId="firstName" />

            <label for="middleName">Middle Name:</label>
            <html:text property="middleName" styleId="middleName" />

            <label for="lastName">Last Name:</label>
            <html:text property="lastName" styleId="lastName" />

            <html:submit value="Sign up" />
        </html:form>
    </div>
</body>
</html>
