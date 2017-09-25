<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="language" value="${pageContext.response.locale}" scope="request" />
<s:url value="/spittles" var="spittleUrl">
    <s:param name="max" value="60" />
    <s:param name="count" value="10" />
</s:url>

<!DOCTYPE html>
<html lang="<c:out value="${language}" />">
<head>
    <title>Spittr</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1><s:message code="spittr.home.welcome" /></h1>
    <a href="${spittleUrl}"><s:message code="spittr.home.spittles" /></a> |
    <a href="<c:url value="/spitter/register" />"><s:message code="spittr.home.register" /></a><br/>
    <span>Language: <a href="?lang=ru">Russian</a> | <a href="?lang=en">English</a></span><br/>
    <span>Current Locale :<c:out value="${language}" /></span>
    <div>
        <span>
            <s:escapeBody htmlEscape="true" >Application: </s:escapeBody>
        </span>
        <span>
            <s:eval expression="@environment['application.name']" />
        </span>
    </div>
    <div>
        <span>Version: </span>
        <span><s:eval expression="@environment['build.version']" /></span>
    </div>
    <div>
        <span>Building date: </span>
        <span><s:eval expression="@environment['build.timestamp']" /></span>
    </div>
</body>
</html>
