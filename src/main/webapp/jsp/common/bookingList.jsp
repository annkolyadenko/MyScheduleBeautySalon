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
        <div class="col-lg-6 col-sm-6 ">
            <br>
            <ctg:if-user role="administrator">
                <h5>Hello, ${sessionScope.authorizedUser.name}!</h5>
                <h5>Please, select master and date:</h5>
            </ctg:if-user>
            <ctg:if-user role="master">
                <h5>Hello, ${sessionScope.authorizedUser.name}!</h5>
                <h5>Please, select desirable date:</h5>
            </ctg:if-user>
            <ctg:if-user role="client">
                <h5>Thank you for choosing us!</h5>
                <h5>Please, select your favourite master and date:</h5>
            </ctg:if-user>
            <br>
            <ctg:if-user role="administrator">
                <form action="controller" method="POST">
                    <label for="selectAdmin">Please, select master</label>
                    <select id="selectAdmin" name="masterId">
                        <option value="">Choose...</option>
                        <c:forEach var="master" items="${mastersList}" varStatus="status">
                            <c:choose>
                                <c:when test="${master!=null}">
                                    <option value="${master.id}">${master.name}</option>
                                </c:when>
                                <c:when test="${master==null}">
                                    No available
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <p>
                        <label for="dateAdmin">Select your date</label>
                        <input type="date" id="dateAdmin" name="chosenDate" value="">
                    </p>
                    <p>
                        <button type="submit" name="command" value="GET_BOOKINGS_BY_MASTER_AND_DATE">Submit</button>
                    </p>
                </form>
            </ctg:if-user>
            <ctg:if-user role="master">
                <form action="controller" method="POST">
                        <%--<label for="select">Select your master</label>
                        <select id="select" name="masterId">
                            <option value="">Choose...</option>
                            <c:forEach var="master" items="${mastersList}" varStatus="status">
                                <c:choose>
                                    <c:when test="${master!=null}">
                                        <option value="${master.id}">${master.name}</option>
                                    </c:when>
                                    <c:when test="${master==null}">
                                        No available
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </select>--%>
                    <p>
                        <label for="dateMaster">Select your date</label>
                        <input type="date" id="dateMaster" name="chosenDate" value="">
                    </p>
                    <p>
                        <button type="submit" name="command" value="GET_BOOKINGS_BY_MASTER_AND_DATE">Submit</button>
                    </p>
                </form>
            </ctg:if-user>
            <ctg:if-user role="client">
                <form action="controller" method="POST">
                    <label for="selectClient">Please, select master</label>
                    <select id="selectClient" name="masterId">
                        <option value="">Choose...</option>
                        <c:forEach var="master" items="${mastersList}" varStatus="status">
                            <c:choose>
                                <c:when test="${master!=null}">
                                    <option value="${master.id}">${master.name}</option>
                                </c:when>
                                <c:when test="${master==null}">
                                    No available
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <p>
                        <label for="dateClient">Select your date</label>
                        <input type="date" id="dateClient" name="chosenDate" value="">
                    </p>
                    <p>
                        <button type="submit" name="command" value="GET_BOOKINGS_BY_MASTER_AND_DATE">Submit</button>
                    </p>
                </form>
            </ctg:if-user>

        </div>
        <div class="col-lg-6 col-sm-6 ">
            <c:if test="${requestScope.bookings!=null}">
                <br>
                <ctg:if-user role="administrator">
                    <h5>Chosen master: ${requestScope.masterName}</h5>
                </ctg:if-user>
                <ctg:if-user role="master">
                    <h5>${requestScope.masterName},</h5>
                </ctg:if-user>
                <ctg:if-user role="client">
                    <h5>Chosen master: ${requestScope.masterName}</h5>
                    <h5>Phone number: ${requestScope.masterPhone}</h5>
                </ctg:if-user>
                <h5>Bookings for: ${requestScope.date}</h5>
                <table class="table table-hover table-bordered text-center">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Time-slot</th>
                        <th scope="col">Booking status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <input type="hidden" name="startTime" value="${i+8}:00" id="hiddenStartTime"/>
                    <c:forEach var="i" begin="0" end="9" varStatus="loop">
                        <tr>
                            <td>${i+8}:00</td>
                            <td>
                                <c:choose>
                                    <c:when test="${requestScope.bookings[i]!=null}">
                                        <ctg:if-user role="administrator">
                                            ${requestScope.bookings[i].client.name}
                                        </ctg:if-user>
                                        <ctg:if-user role="master">
                                            ${requestScope.bookings[i].client.name}
                                        </ctg:if-user>
                                        <ctg:if-user role="client">
                                            Booked
                                        </ctg:if-user>
                                    </c:when>
                                    <c:when test="${requestScope.bookings[i]==null}">
                                        <ctg:if-user role="administrator">
                                            Available
                                        </ctg:if-user>
                                        <ctg:if-user role="master">
                                            Available
                                        </ctg:if-user>
                                        <ctg:if-user role="client">
                                        <form class="form" method="POST" action="controller">
                                            <input type="hidden" name="masterName" value="${requestScope.masterName}">
                                            <input type="hidden" name="chosenDate" value="${requestScope.date}">
                                            <input type="hidden" name="chosenTime" value="${i+8}:00">
                                            <button type="submit" class="btn btn-primary" name="command" value="ADD_BOOKING">Make booking
                                            </button>
                                        </form>
                                        </ctg:if-user>
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"></c:import>
</html>

