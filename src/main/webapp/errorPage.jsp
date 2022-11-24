<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function reloadThePage(){
        window.location.reload(true);
    }
</script>
<body>
<%Account account = (Account) session.getAttribute("account");%>
<%account.setGameOverCount(account.getGameOverCount() + 1);%>
<%String wrongAnswerDescription = (String) request.getAttribute("wrong_answer_description");%>

<form action="/login" method="get">
    <p><%=wrongAnswerDescription%>
    </p>
    <input type="submit" value="RESTART GAME"/>
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
