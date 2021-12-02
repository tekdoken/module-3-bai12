<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/2/2021
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body><h1>list Product</h1>

<form action="/products?act=findName" method="post">
  <input type="text" name="name" placeholder="enter name"><button>find</button>
</form>

<h1><a href="/products?act=sort">order</a></h1>

<h2><a href="/products?act=create">create</a></h2>
<c:forEach var="pro" items="${listProduct}">
  <h2>${pro.id},${pro.name},${pro.price},${pro.quantity}</h2>, <a href="/products?act=edit&id=${pro.id}">edit</a> , <a href="/products?act=delete&id=${pro.id}">delete</a>
</c:forEach>
</body>
</html>
