<%--
  Created by IntelliJ IDEA.
  User: Yolanda
  Date: 06/10/2017
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>宝宝淘论坛登陆</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="#663399"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value="/loginCheck.html" />" method="post">
        user name:
        <input type="text" name="userName">
        <br>
        password:
        <input type="password" name="password">
        <br>
        <input type="submit" value="Login">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
