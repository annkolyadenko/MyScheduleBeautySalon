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