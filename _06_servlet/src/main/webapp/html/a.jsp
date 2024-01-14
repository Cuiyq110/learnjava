<%--
  Created by IntelliJ IDEA.
  User: cyq11
  Date: 2024/1/12
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form
        action="http://localhost:8080/_06_servlet_war_exploded/HelloServlet" method="get">
    <input type="submit" value="HelloServlet"/>
</form>
<form
        action="http://localhost:8080/_06_servlet_war_exploded/HelloServlet2" method="get">
    <input type="submit" value="HelloServlet2"/>
</form>
<form
        action="http://localhost:8080/_06_servlet_war_exploded/HelloServlet3" method="get">
    <input type="submit" value="HelloServlet3"/>
</form>
<form action="http://localhost:8080/_06_servlet_war_exploded/ContextServlet1" method="get">
    <input type="submit" value="ContextServlet1"/>
</form>
</body>
</html>
