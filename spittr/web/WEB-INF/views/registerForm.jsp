<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
        <h1><s:message code="spittr.registerForm.headler" /></h1>
        <sf:form method="POST" commandName="spitter">
            <sf:errors path="*" element="div" cssClass="errors" />
            <sf:label path="firstName" cssErrorClass="error"><s:message code="spittr.registerForm.firstName" /></sf:label><sf:input cssErrorClass="error" path="firstName" /><br/>
            <sf:label path="lastName" cssErrorClass="error"><s:message code="spittr.registerForm.lastName" /></sf:label><sf:input cssErrorClass="error" path="lastName" /><br/>
            <sf:label path="email" cssErrorClass="error"><s:message code="spittr.registerForm.email" /></sf:label><sf:input cssErrorClass="error" path="email" /><br/>
            <sf:label path="username" cssErrorClass="error"><s:message code="spittr.registerForm.username" /></sf:label><sf:input cssErrorClass="error" path="username" /><br/>
            <sf:label path="password" cssErrorClass="error"><s:message code="spittr.registerForm.password" /></sf:label><sf:password cssErrorClass="error" path="password" /><br/>
            <input type="submit" value="<s:message code="spittr.registerForm.submitButton" />">
        </sf:form>
    </div>
</body>
</html>
