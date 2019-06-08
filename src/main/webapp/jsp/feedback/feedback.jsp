<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="/web_resources/images/eye.jpeg" type="image/ico">
    <title>Feedback Page</title>
</head>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <div class="row">
        <form method="POST" action="controller">
        <br>
        <h4><i class="material-icons" style="color:red">favorite</i>Please, ${userName}, leave your feedback</h4>

        <h4>Your date and time of visit: ${bookingDate} ${bookingTime} </h4>
        <h4>Your master: ${masterName}</h4>
        <br>
            <textarea class="form-control" id="formControlTextarea" rows="3" name="review" value=""></textarea>
            <input type="hidden" name="bookingId" value=${bookingId}>
            <br>
            <button class="btn btn-dark" type="submit" name="command" value="APPROVE_FEEDBACK">Submit</button>
        </form>
    </div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>