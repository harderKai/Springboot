<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022/5/18
  Time: 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="Css/fileShow.css" />

</head>
<body>
<h1>${fileName}</h1>
<h1>${destFileName}</h1>
<c:forEach items="${f}" var="file" varStatus="st">
<div>
    ${file.id}<img src="uploaded/${file.img}"/>
</div>
</c:forEach>
</body>
</html>
