<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="language" value="${pageContext.response.locale}" scope="request" />
<s:url value="/spittles" var="spittleUrl">
    <s:param name="max" value="60" />
    <s:param name="count" value="10" />
</s:url>

<h1><s:message code="spittr.home.welcome" /></h1>
<a href="${spittleUrl}"><s:message code="spittr.home.spittles" /></a> |
<a href="<c:url value="/spitter/register" />"><s:message code="spittr.home.register" /></a><br/>

