<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="language" value="${pageContext.response.locale}" scope="request" />

<!DOCTYPE html>
<html lang="<c:out value="${language}" />">
<head>
    <title>Spittr</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1><s:message code="spittr.home.welcome" /></h1>
    <a href="<c:url value="/spittles" />"><s:message code="spittr.home.spittles" /></a> |
    <a href="<c:url value="/spitter/register" />"><s:message code="spittr.home.register" /></a><br/>
    <span>Language: <a href="?lang=ru">Russian</a> | <a href="?lang=en">English</a></span><br/>
    <span>Current Locale :<c:out value="${language}" /></span>
</body>
</html>
