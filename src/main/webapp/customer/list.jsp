<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 12/1/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>h1>list Customer</h1>
<form action="/customers?act=find" method="post">
    <input type="number" name="id" placeholder="enter id"><button>find</button>
</form>
<form action="/customers?act=findName" method="post">
    <input type="text" name="name" placeholder="enter name"><button>find</button>
</form>
<form action="/customers?act=delete" method="post">
    <input type="number" name="id" placeholder="enter id"><button>delete</button>
</form>
<h1><a href="/customers?act=order">order</a></h1>

<h2><a href="/customers?act=create">create</a></h2>
<c:forEach var="cus" items="${listCustomer}">
    <h2>${cus.id},${cus.name},${cus.age},</h2><a href="/customers?act=edit&id=${cus.id}">edit</a> </h2>,<a href="/customers?act=delete&id=${cus.id}">delete</a>
</c:forEach>
</body>
</html>
