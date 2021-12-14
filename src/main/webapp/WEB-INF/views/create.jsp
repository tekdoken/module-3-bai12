<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/create" method="post">
    <input type="text" name="name">
    <input type="text" name="description">
    <input type="text" name="color">
    <input type="number" name="price">
    <input type="number" name="quantity">
    <input type="number" name="categoryId">
<%--    <select name="categoryId" id="">--%>
<%--        <c:forEach var="i" begin="0" end="${category.size()-1}">--%>
<%--            <option value="${category.get(i).id}"> ${category.get(i).name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
    <button>create</button>
</form>
</body>
</html>
