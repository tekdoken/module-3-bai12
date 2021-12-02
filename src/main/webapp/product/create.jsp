<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/2/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<form action="/products?act=create" method="post">
    <input type="number" name="id">
    <input type="text" name="name">
    <input type="number" name="price">
    <input type="number" name="quantity">
    <button>create</button>
</form>
</body>
</html>
