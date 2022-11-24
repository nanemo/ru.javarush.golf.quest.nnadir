<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You win</title>
</head>

<body>
<%Account account = (Account) session.getAttribute("account");%>
<%account.setWinCount(account.getWinCount() + 1);%>
<form action="<c:url value="/home.jsp"/>">
    <h1>You win</h1>
    <input type="submit"
           value="PLAY AGAIN"/>
    <input type="hidden" name="account_name" value="<%=account.getName()%>">
    <h3>PLAYER NAME: <%=account.getName()%>
    </h3>
    <h3>GAME: <%=account.getPlayCount()%>
    </h3>
    <h3>WIN: <%=account.getWinCount()%>
    </h3>
    <h3>GAME OVER: <%=account.getGameOverCount()%>
    </h3>
    <%account.setPlayCount(account.getPlayCount() + 1);%>
    <a href="login.jsp">LOG OUT</a>
</form>
</body>
</html>
