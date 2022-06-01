<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022/5/16
  Time: 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;

        }
        a:hover{
            color: aqua;
        }
    </style>
</head>
<body>
<span style="display:block;text-align:center;font-family: 'Segoe UI Historic'">Hi JSP. 现在时间是  ${now}</span>
<span style="display:block;text-align:center;font-family: 'Segoe UI Historic';margin-top: 200px;font-size: large"><a href="/listAllUsers">展示所有的用户</a></span>
</body>
</html>
