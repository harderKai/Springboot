<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022/5/17
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<table>--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>name</td>--%>
    <%--</tr>--%>
<%--<c:forEach items="${list}" var="c" varStatus="st">--%>
    <%--<tr>--%>
        <%--<td>${c.id}</td>--%>
        <%--<td>${c.name}</td>--%>
    <%--</tr>--%>

<%--</c:forEach>--%>
<%--</table>--%>


<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="listCategory?start=0">[首  页]</a>
        <a href="listCategory?start=${page.number-1}">[上一页]</a>
        <a href="listCategory?start=${page.number+1}">[下一页]</a>
        <a href="listCategory?start=${page.totalPages-1}">[末  页]</a>
    </div>
    <br>
    <form action="addCategory" method="post">

        name: <input name="name"> <br>
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
