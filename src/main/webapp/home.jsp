<%@ page import="java.util.List" %>
<%@ page import="ru.javarush.quest.entity.Answer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body class="bg">
<div>
    <img src="img/hi_human.jpg">
</div>
<form action="/logic" method="GET">
    <%String accountName = (String) request.getAttribute("account_name");%>
    <input type="submit" value="START GAME"/>
    <input type="hidden" name="account_name" value="<%=accountName%>">
    <h3><%=accountName%>
    </h3>
    <a href="login.jsp">LOG OUT</a>
</form>

</body>
</html>