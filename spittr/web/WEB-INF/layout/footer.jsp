<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
        <footer class="container-fluid text-center">
            <span>
                    <s:eval expression="@environment['application.name']"/>
                    <s:eval expression="@environment['build.version']"/>
                    <s:eval expression="@environment['build.timestamp']"/>
                </span>
            <div>
                <a href="<s:url value=""><s:param name="lang" value="en" /></s:url> ">English</a>
                <span> | </span>
                <a href="<s:url value=""><s:param name="lang" value="ru" /></s:url> ">
                    <s:message code="spittr.footer.languageLink"/>
                </a>
            </div>
        </footer>
