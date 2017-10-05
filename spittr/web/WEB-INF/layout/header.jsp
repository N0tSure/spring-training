<%@ taglib uri="http://www.springframework.org/tags" prefix="s"  %>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<s:url value="/" />">Spittr</a>
                </div>
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<s:url value="/" />">
                            <s:message code="spittr.header.homeLink" />
                        </a>
                    </li>
                    <li>
                        <a href="<s:url value="/spittles" />">
                            <s:message code="spittr.header.spittlesLink" />
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="<s:url value="/spitter/register" />">
                            <s:message code="spittr.header.registerLink" />
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
