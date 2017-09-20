<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spittr</title>
    <style type="text/css">
        div.errors {
            background: #ffcccc;
            border: 2px solid red;
        }
        label.error {
            color: darkred;
        }
        input.error {
            background-color: #ffcccc;
        }
    </style>
</head>
<body>
    <div>
        <h1>Register</h1>
        <sf:form method="POST" commandName="spitter">
            <sf:errors path="*" element="div" cssClass="errors" />
            <sf:label path="firstName" cssErrorClass="error">First name: </sf:label><sf:input cssErrorClass="error" path="firstName" /><br/>
            <sf:label path="lastName" cssErrorClass="error">Last name: </sf:label><sf:input cssErrorClass="error" path="lastName" /><br/>
            <sf:label path="email" cssErrorClass="error">Email: </sf:label><sf:input cssErrorClass="error" path="email" /><br/>
            <sf:label path="username" cssErrorClass="error">Username: </sf:label><sf:input cssErrorClass="error" path="username" /><br/>
            <sf:label path="password" cssErrorClass="error">Password: </sf:label><sf:password cssErrorClass="error" path="password" /><br/>
            <input type="submit" value="Register">
        </sf:form>
    </div>
</body>
</html>
