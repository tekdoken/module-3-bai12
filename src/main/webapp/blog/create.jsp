<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/9/2021
  Time: 2:07 AM
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
<form action="/?action=create" method="post">
    <input type="text" name="tittle">
    <input type="text" name="content">
    <select name="categoryId" id="">
        <c:forEach var="i" begin="0" end="${category.size()-1}">
            <option value="${category.get(i).id}"> ${category.get(i).name}</option>
        </c:forEach>
    </select>
    <button>create</button>
</form>
</body>
</html>
