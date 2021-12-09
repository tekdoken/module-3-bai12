<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/9/2021
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/?action=create" method="post">
    <input type="text" name="name">
    <input type="text" name="description">
    <input type="text" name="color">
    <input type="number" name="price">
    <input type="number" name="quantity">
    <select name="categoryId" id="">
        <c:forEach var="i" begin="0" end="${category.size()-1}">
            <option value="${category.get(i).id}"> ${category.get(i).name}</option>
        </c:forEach>
    </select>
    <button>create</button>
</form>
</body>
</html>
