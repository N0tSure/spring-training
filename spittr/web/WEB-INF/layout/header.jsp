<%@ taglib uri="http://www.springframework.org/tags" prefix="s"  %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<s:url value="/" />">Spittr</a>
        </div>
        <ul class="nav navbar-nav">
            <li>
                <a href="<s:url value="/" />">Home</a>
            </li>
            <li>
                <a href="<s:url value="/spittles" />">Spittles</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="<s:url value="/spitter/register" />">
                    <span class="glyphicon glyphicon-user"> Register</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
