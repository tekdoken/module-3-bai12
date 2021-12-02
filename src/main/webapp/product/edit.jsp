<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/2/2021
  Time: 3:23 PM
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
<a href="/products?act=ds">back</a>
<form action="/products?act=edit&id=${editProduct.id}" method="post">
    name <input type="text" name="name"  value="${editProduct.name}">
    price <input type="number" name="price" value="${editProduct.price}">
    quantity <input type="number" name="quantity" value="${editProduct.quantity}">
    <button>edit</button>
</form>
</body>
</html>
