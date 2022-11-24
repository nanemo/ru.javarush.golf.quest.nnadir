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
<div>
    <form action="/logic" method="POST">
        <%Account account = (Account) session.getAttribute("account");%>

        <%String question = (String) request.getAttribute("question");%>
        <%String corAns = (String) request.getAttribute("cor_answer");%>
        <%String wroAns = (String) request.getAttribute("wro_answer");%>
        <p><%=question%>
        </p>
        <br>
        <label for="cor"><%=corAns%> <br>
            <button type="submit" id="cor" name="boolean_for_answer" value="true"></button>
        </label>
        <br>
        <label for="wro"><%=wroAns%> <br>
            <button type="submit" id="wro" name="boolean_for_answer" value="false"></button>
            <br>
        </label>
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
</div>

</body>
</html>
