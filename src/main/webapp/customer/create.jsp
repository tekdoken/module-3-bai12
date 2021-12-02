<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/1/2021
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customers?act=create" method="post">
    <input type="number" name="id">  <input type="text" name="name">
    <input type="number" name="age">

    <button>create</button>
</form>
</body>
</html>
