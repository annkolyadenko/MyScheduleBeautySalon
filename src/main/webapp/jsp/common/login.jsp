<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="/web_resources/images/eye.jpeg" type="image/ico">
    <title>Login</title>
</head>
<c:import url="/jsp/dependencies.jsp"/>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <h1>Welcome on board!</h1>
</div>
<%--<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value="" placeholder="example@example.com"/>
    <br/>Password:<br/>
    <input type="password" name="password" value="" placeholder="password"/>
    <br/>
    ${ErrorLoginMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Log in"/>
</form>--%>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>
