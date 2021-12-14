<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/9/2021
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="post">
    <input type="hidden" type="number" name="id" value="${editProduct.id}">
    <input type="text" name="name" value="${editProduct.name}">
    <input type="text" name="description" value="${editProduct.description}">
    <input type="text" name="color" value="${editProduct.color}">
    <input type="number" name="price" value="${editProduct.price}">
    <input type="number" name="quantity" value="${editProduct.quantity}">
<%--    <input type="text" name="categoryId" value="${category.get(i).id}" >--%>
    <select name="categoryId" id=">
        <c:forEach var="i" begin="0" end="${category.size()-1}">
            <option value="${category.get(i).id}"> ${category.get(i).name}</option>
        </c:forEach>
    </select>
    <button>edit</button>
</form>
</body>
</html>
