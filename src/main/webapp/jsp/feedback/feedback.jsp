<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="/web_resources/images/eye.jpeg" type="image/ico">
    <title>Client Page</title>
</head>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <div class="row">
        <br>
        <h5>Please, ${userName}, leave your feedback<i class="material-icons" style="color:red">favorite</i></h5>
        <br>
        <h5>Your date and time of visit: ${bookingDate} ${bookingTime} </h5>
        <h5>Your master: ${masterName}</h5>
        <br>
        <div class="form-group">
            <form class="form" method="POST" action="controller">
                <label for="formControlTextarea">Your feedback</label>
                <textarea class="form-control" id="formControlTextarea" rows="3" name="review" value=""></textarea>
                <button class="btn btn-dark" type="submit" name="command" value="APPROVE_FEEDBACK">Submit</button>
            </form>
        </div>
    </div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>