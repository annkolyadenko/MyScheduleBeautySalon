<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Navigation</title>
</head>
<c:import url="/jsp/dependencies.jsp"/>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#"><img src="/web_resources/images/beauty3.jpg" width="120" height="120"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ctg:if-user role="empty">
                <ul class="nav navbar-nav mr-auto">
                    <li><p class="navbar-text" style="color:#d42819; text-transform: none">Already have an account?</p>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="Login" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Login
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Login">
                            <form class="form" method="POST" action="controller">
                                <input type="hidden" name="command" value="login"/>
                                <div class="form-group">
                                    <label class="sr-only" for="inputEmail">Email address</label>
                                    <input type="email" class="form-control" id="inputEmail" name="login" value=""
                                           placeholder="Email address" required>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="inputPassword">Password</label>
                                    <input type="password" class="form-control" id="inputPassword" name="password"
                                           value="" placeholder="Password" required>
                                </div>
                                    <%-- ${ErrorLoginMessage}
                                 <br/>
                                     ${wrongAction}
                                 <br/>
                                     ${nullPage}
                                 <br/>--%>
                                <div class="form-group">
                                    <label class="sr-only" for="submit">Submit</label>
                                    <input type="submit" class="form-control mb-1 bg-secondary text-white" id="submit"
                                           value="Submit">
                                    <div class="help-block text-right"
                                         style="font-size: 12px; text-transform: lowercase"><a href="">Forget the
                                        password?</a></div>
                                </div>
                            </form>
                            <div class="bottom text-center" style="font-size: 12px; text-transform: none">
                                New here ? <a class="form-control mb-1 bg-secondary text-white" href="#"><b>Join Us</b></a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Prices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="Language" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Language
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Language">
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Україні</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Glory to Ukraine</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Украине</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>
            </ctg:if-user>
            <ctg:if-user role="administrator">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/controller?command=return">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="Menu1" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Menu1">
                            <a class="dropdown-item mb-1 bg-secondary text-white" <%--href="#"--%>
                               href="/controller?command=GET_ALL_MASTERS">Bookings</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Reviews</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Edit master</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Edit services</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Edit about</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/controller?command=logout">Log out</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Prices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Language
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Language">
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Україні</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Glory to Ukraine</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Украине</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <%@ include file="/jsp/common/header.jsp" %>
                    </li>
                </ul>
            </ctg:if-user>
            <ctg:if-user role="master">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/controller?command=return">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="Menu2" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Menu2">
                            <a class="dropdown-item mb-1 bg-secondary text-white" <%--href="#"--%>
                                href="/controller?command=GET_BOOKINGS_BY_MASTER_AND_DATE">My bookings</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">My reviews</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/controller?command=logout">Log out</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Prices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Language
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Language">
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Україні</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Glory to Ukraine</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Cлава Украине</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <%@ include file="/jsp/common/header.jsp" %>
                    </li>
                </ul>
            </ctg:if-user>
            <ctg:if-user role="client">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/controller?command=RETURN">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/controller?command=GET_ALL_MASTERS">New booking</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="Menu" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Menu">
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">My bookings</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">My reviews</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/controller?command=LOGOUT">Log out</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Prices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Language
                        </a>
                        <div class="dropdown-menu" aria-labelledby="Language">
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Україні</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Glory to Ukraine</a>
                            <a class="dropdown-item mb-1 bg-secondary text-white" href="#">Слава Украине</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <%@ include file="/jsp/common/header.jsp" %>
                    </li>
                </ul>
            </ctg:if-user>
        </div>
    </nav>
</header>
<%--<div class="slogan">
    <p>Who can realize the bliss and solitude of a believer if he has the remarkable enlightenment of the teacher?</p>
    <p>Everything we do is connected with issue: solitude, beauty, tantra, moonlight.</p>
    <p>Man is the only core, the only guarantee of heaven.</p>
</div>--%>
<%--<nav class="nav-pagination">
    <ul class="pagination justify-content-center">
        <li class="page-item ">
            <a class="page-link bg-light text-dark" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <li class="page-item active"><a class="page-link bg-light text-dark" href="#">1</a></li>
        <li class="page-item"><a class="page-link bg-light text-dark" href="#">2</a></li>
        <li class="page-item"><a class="page-link bg-light text-dark" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link bg-light text-dark" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>
</nav>--%>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
