<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head>
    <title>Spittr</title>
</head>
<body>
    <h1><s:message code="spittr.home.welcome" /></h1>
    <a href="<c:url value="/spittles" />"><s:message code="spittr.home.spittles" /></a> |
    <a href="<c:url value="/spitter/register" />"><s:message code="spittr.home.register" /></a><br/>
    Language: <a href="?lang=ru">Russian</a> | <a href="?lang=en">English</a> <br/>
    Current Locale : ${pageContext.response.locale}
</body>
</html>
