<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<div>
    <h1><s:message code="spittr.profile.headler" /></h1>
    <div>
        <c:out value="${spitter.username}" />
    </div>
    <div>
        <c:out value="${spitter.firstName}" />
        <c:out value="${spitter.lastName}" />
    </div>
</div>
</body>
</html>
