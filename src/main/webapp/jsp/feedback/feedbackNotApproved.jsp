<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="/web_resources/images/eye.jpeg" type="image/ico">
    <title>Feedback not approved!</title>
</head>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <div class="row">
        <h4><i class="material-icons" style="color:red">sentiment_very_dissatisfied</i> Sorry, but you can't leave two feedbacks per one visit!</h4>
    </div>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>
