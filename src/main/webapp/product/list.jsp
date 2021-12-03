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

<form>
  <input type="text" name="name" placeholder="enter name"><button>find</button>
</form>


<h1><a href="/products?act=sort">sort</a></h1>

<h2><a href="/products?act=create">create</a></h2>
<c:forEach var="pro" items="${listProduct}">

<form action="/products?act=edit&id=${pro.id}" method="post">
  name: <input style="border: none" type="text" name="name"  value="${pro.name}">
  price: <input style="border: none" type="number" name="price" value="${pro.price}">
  quantity: <input style="border: none" type="number" name="quantity" value="${pro.quantity}">
  <button onclick="if (confirm('Edit selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">edit</button>
  <a href="/products?act=delete&id=${pro.id}" onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">
  delete
</a>
</form>
</c:forEach>
</body>
</html>
