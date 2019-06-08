<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <div class="nav-header">
        Hello, <c:out value="${sessionScope.authorizedUser.name}"/>
        <p>Your role: <c:out value="${sessionScope.authorizedUser.role}"/>
    </div>
</body>
</html>