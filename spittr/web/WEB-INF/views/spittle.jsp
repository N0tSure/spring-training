<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
<div>
    <div>
        <c:out value="${spittle.message}" />
    </div>
    <div>
        <c:out value="${spittle.timestamp}" />
    </div>
</div>
</body>
</html>
