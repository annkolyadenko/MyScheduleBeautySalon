<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <link rel="shortcut icon" href="/web_resources/images/eye.jpeg" type="image/ico">
    <title>Thank You</title>
</head>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <div class="row">
        <h4>
            <img src="/web_resources/images/beauty4.jpg" width="120" height="120">
            Thank You,
            ${sessionScope.authorizedUser.name},
            your booking was approved!
        </h4>
    </div>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>