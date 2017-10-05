<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<s:url value="/spittles" var="spittleUrl">
    <s:param name="max" value="60" />
    <s:param name="count" value="10" />
</s:url>
        <div class="container-fluid">
            <div class="jumbotron">
                <h1>
                    <s:message code="spittr.home.welcome" />
                </h1>
                <p>
                    <span>
                        <a class="btn btn-default btn-lg" href="${spittleUrl}">
                            <s:message code="spittr.home.spittles" />
                        </a>
                    </span>
                    <span>
                        <a class="btn btn-default btn-lg" href="<c:url value="/spitter/register" />">
                            <s:message code="spittr.home.register" />
                        </a>
                    </span>
                </p>
            </div>
        </div>
