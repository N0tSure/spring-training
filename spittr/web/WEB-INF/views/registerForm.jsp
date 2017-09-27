<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h1>
        <s:message code="spittr.registerForm.headler" />
    </h1>
    <sf:form method="POST" commandName="spitter">
        <div class="form-group">
            <div class="row">
                <div class="col-md-4">
                    <sf:label path="firstName">
                        <s:message code="spittr.registerForm.firstName" />
                    </sf:label>
                    <sf:input cssClass="form-control" path="firstName" />
                </div>
                <div class="col-md-8">
                    <sf:errors path="firstName" element="div" cssClass="alert alert-danger" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-md-4">
                    <sf:label path="lastName">
                        <s:message code="spittr.registerForm.lastName" />
                    </sf:label>
                    <sf:input cssClass="form-control" path="lastName" />
                </div>
                <div class="col-md-8">
                    <sf:errors path="lastName" element="div" cssClass="alert alert-danger" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-md-4">
                    <sf:label path="email">
                        <s:message code="spittr.registerForm.email" />
                    </sf:label>
                    <sf:input cssClass="form-control" path="email" />
                </div>
                <div class="col-md-8">
                    <sf:errors path="email" element="div" cssClass="alert alert-danger" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-md-4">
                    <sf:label path="username">
                        <s:message code="spittr.registerForm.username" />
                    </sf:label>
                    <sf:input cssClass="form-control" path="username" />
                </div>
                <div class="col-md-8">
                    <sf:errors path="username" element="div" cssClass="alert alert-danger" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-md-4">
                    <sf:label path="password">
                        <s:message code="spittr.registerForm.password" />
                    </sf:label>
                    <sf:password cssClass="form-control" path="password" />
                </div>
                <div class="col-md-8">
                    <sf:errors path="password" element="div" cssClass="alert alert-danger" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="submit" class="btn btn-primary" value="<s:message code="spittr.registerForm.submitButton" />">
            </div>
        </div>
    </sf:form>
</div>
