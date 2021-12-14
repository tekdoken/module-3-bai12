<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/9/2021
  Time: 9:35 AM
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
<form method="get">
    <input type="text" name="name" placeholder="enter name"><button>find</button>
</form>
<table border="1" cellpadding="5">
    <caption><h2>List of Blog</h2></caption>
    <a href="/createForm"> Create</a>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>price</th>
        <th>quantity</th>
        <th>color</th>
        <th>description</th>
        <th>category name</th>
        <th>action</th>
    </tr>
    <c:forEach var="i" begin="0" end="${newproduct.size()-1}">
        <tr>
            <td>${newproduct.get(i).id}</td>
            <td>${newproduct.get(i).name}</td>
            <td>${newproduct.get(i).price}</td>
            <td>${newproduct.get(i).quantity}</td>
            <td>${newproduct.get(i).color}</td>
            <td>${newproduct.get(i).description}</td>
            <td>${category.get(i).name}</td>
            <td>
                <a href="/editForm?id=${newproduct.get(i).id}">Edit</a>
                <a href="/delete?id=${newproduct.get(i).id}" onclick="return confirm('Delete selected item?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
