<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/1/2021
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="customers?act=ds">sdfsfd</a>
<form action="/customers?act=edit&id=${editCustomer.id}" method="post">
    name <input type="text" name="name"  value="${editCustomer.name}">
   age <input type="number" name="age" value="${editCustomer.age}">
    <button>edit</button>
</form>
</body>
</html>
