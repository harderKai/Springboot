<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022/5/18
  Time: 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateCategory" metho="get">
    id:<input type="text" name="id" value="${c.id}" style="display:none">
    name:<input  type="text" name="name" placeholder="${c.name}">
    <input type="submit" value="确认提交">
</form>
</body>
</html>
