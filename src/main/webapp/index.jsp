<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--charset=UTF-8 - кодировка страницы, полученной в результате работы JSP. JSP скомпилировали,
использовав pageEncoding, вызвали – и она сгенерировала страницу в кодировке charset.
pageEncoding="UTF-8 - это кодировка текущего файла JSP.
Если один параметр опущен – другой принимается равным ему.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h>nulla dies sine linea</h>
<%--<c:redirect url="jsp/common/login.jsp"/>--%>
<jsp:forward page="jsp/common/login.jsp"/>
</body>
</html>
