<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <link rel="shortcut icon" href="/resources/images/eye.jpeg" type="image/ico">
    <title>Bookings</title>
</head>
<body>
<c:import url="/jsp/common/navigation.jsp"></c:import>
<div class="container" style="height: 100%">
    <div class="row">
        <form>
            <br>
            ${sessionScope.authorizedUser.name}, you've chosen:
            <br>
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Master name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Time</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${bookMasterName}</td>
                    <td>${bookDate}</td>
                    <td>${bookTime}</td>
                </tr>
                </tbody>
            </table>
            <button type="submit" name="command" value="APPROVE_BOOKING">Submit</button>
        </form>
    </div>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>