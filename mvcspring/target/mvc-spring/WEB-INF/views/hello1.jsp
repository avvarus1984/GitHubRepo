<%--
  Created by IntelliJ IDEA.
  User: Avvarus
  Date: 1/27/18
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>${username}</h3>
<h3>${message}</h3>

<a href="<c:url value="/j_spring_security_logout" />"><b>Click here to logout !! </b></a>

</body>
</html>
