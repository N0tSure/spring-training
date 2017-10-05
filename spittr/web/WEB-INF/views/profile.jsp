<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>
                <s:message code="spittr.profile.headler" />
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4><s:message code="spittr.profile.fullName" />:</h4>
        </div>
        <div class="col-md-4">
            <h4>
                <span><c:out value="${spitter.firstName}" /></span>
                <span><c:out value="${spitter.lastName}" /></span>
            </h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4><s:message code="spittr.profile.userName" />:</h4>
        </div>
        <div class="col-md-4">
            <h4>
                <c:out value="${spitter.username}" />
            </h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4>Email:</h4>
        </div>
        <div class="col-md-4">
            <h4>
                <c:out value="${spitter.email}" />
            </h4>
        </div>
    </div>
</div>
