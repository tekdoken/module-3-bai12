<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/8/2021
  Time: 11:05 PM
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
<table border="1" cellpadding="5">
    <caption><h2>List of Blog</h2></caption>
    <a href="/?action=create"> Create</a>
    <tr>
        <th>ID</th>
        <th>Tittle</th>
        <th>Content</th>
        <th>CategoryId</th>
        <th>Action</th>
    </tr>
    <c:forEach var="i" begin="0" end="${blog.size()-1}">
        <tr>
            <td><c:out value="${blog.get(i).id}"/></td>
            <td><c:out value="${blog.get(i).tittle}"/></td>
            <td><c:out value="${blog.get(i).content}"/></td>
            <td><c:out value="${category.get(i).name}"/></td>
            <td>
                <a href="/users?action=edit&id=${blog.get(i).id}">Edit</a>
                <a href="/users?action=delete&id=${blog.get(i).id}" onclick="return confirm('Delete selected item?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
