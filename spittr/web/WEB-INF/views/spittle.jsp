<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>
                <s:message code="spittr.spittle.headler" />
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4>
                <s:message code="spittr.spittle.messageSpan" />
            </h4>
        </div>
        <div class="col-md-4">
            <s:eval expression="spittle.message" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4>
                <s:message code="spittr.spittle.dateSpan" />
            </h4>
        </div>
        <div class="col-md-4">
            <s:eval expression="spittle.timestamp" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4>
                <s:message code="spittr.spittle.latitudeSpan" />
            </h4>
        </div>
        <div class="col-md-4">
            <s:eval expression="T(String).format('%10.6f', spittle.latitude)" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h4>
                <s:message code="spittr.spittle.longitudeSpan" />
            </h4>
        </div>
        <div class="col-md-4">
            <s:eval expression="T(String).format('%10.6f', spittle.longitude)" />
        </div>
    </div>
</div>
