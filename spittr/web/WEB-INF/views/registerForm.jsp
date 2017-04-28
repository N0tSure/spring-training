<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<div>
    <h1>Register</h1>
    <form method="post">
        <div>
            <label for="firstName">First name: </label>
            <input id="firstName" type="text" name="firstName" />
        </div>
        <div>
            <label for="lastName">Last name: </label>
            <input id="lastName" type="text" name="lastName" />
        </div>
        <div>
            <label for="username">Username: </label>
            <input id="username" type="text" name="username" />
        </div>
        <div>
            <label for="password">Password: </label>
            <input id="password" type="password" name="password" />
        </div>
        <div>
            <input type="submit" value="Register" />
        </div>
    </form>
</div>
</body>
</html>
