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
    <br>
    <h5>Please, leave your feedback<i class="material-icons" style="color:red">favorite</i></h5>
    <br>
    <table class="table table-sm table-hover table-bordered text-center">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Date & Time</th>
            <th scope="col">Master</th>
            <th scope="col">Review</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                Something
            </td>
            <td>
                Something
            </td>
            <td>
                Something
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>