<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1>
                <s:message code="spittr.spittles.majorHeadler" />
            </h1>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <h4>
                        <s:message code="spittr.spittles.messageHeadler" />
                    </h4>
                </div>
                <div class="col-md-4">
                    <h4>
                        <s:message code="spittr.spittles.dateHeadler" />
                    </h4>
                </div>
                <div class="col-md-4">
                    <h4>
                        <s:message code="spittr.spittles.locationHeadler" />
                    </h4>
                </div>
            </div>
            <c:forEach items="${spittleList}" var="spittle">
                <div class="row spittles" id="spittle_<c:out value="${spittle.id}" />">
                    <div id="spittleMsg" class="col-md-4">
                        <s:eval expression="spittle.message" />
                    </div>
                    <div id="spittleTime" class="col-md-4">
                        <s:eval expression="spittle.timestamp" />
                    </div>
                    <div id="spittleLatitude" class="col-md-4">
                        <span>
                            <s:eval expression="T(String).format('%010.6f', spittle.latitude)" />
                        </span>
                        <span>
                            <s:eval expression="T(String).format('%010.6f', spittle.longitude)" />
                        </span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
