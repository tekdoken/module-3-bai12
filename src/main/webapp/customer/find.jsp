<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/1/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="/customers">list Customer</a></h1>
<c:forEach var="cus" items="${listCustomer}">
    <h2>${cus.id},${cus.name},${cus.age}</h2>
</c:forEach>
</body>
</html>
