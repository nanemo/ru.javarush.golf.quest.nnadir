<%@ page import="java.util.List" %>
<%@ page import="ru.javarush.quest.entity.Answer" %>
<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>



<%--When refreshing a page i have to stay on same page --%>




<body class="bg">
<div>
    <img src="img/hi_human.jpg">
</div>
<form action="/logic" method="GET">
    <%Account account = (Account) session.getAttribute("account");%>


    <input type="submit" value="START GAME"/>
    <input type="hidden" name="account_name" value="<%=account.getName()%>">
    <h3>PLAYER NAME: <%=account.getName()%>
    </h3>
    <h3>GAME: <%=account.getPlayCount()%>
    </h3>
    <h3>WIN: <%=account.getWinCount()%>
    </h3>
    <h3>GAME OVER: <%=account.getGameOverCount()%>
    </h3>
    <a href="login.jsp">LOG OUT</a>
</form>

</body>
</html>