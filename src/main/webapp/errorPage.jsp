<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="css/aliens.css">
    <title></title>
</head>
<script>
    function reloadThePage() {
        window.location.reload(true);
    }
</script>
<body>
<%Account account = (Account) session.getAttribute("account");%>
<%account.setGameOverCount(account.getGameOverCount() + 1);%>
<%String wrongAnswerDescription = (String) request.getAttribute("wrong_answer_description");%>
<div class="game_over_page">
    <form action="/login" method="get">
        <p style="color: white"><%=wrongAnswerDescription%>
        </p>
        <input type="submit" value="RESTART GAME"/>
        <input type="hidden" name="account_name" value="<%=account.getName()%>">
        <a href="login.jsp">LOG OUT</a>
    </form>

    <div style="margin-top: 26%; margin-top: 34%">
        <table id="statistics_table" class="table table-striped-columns">STATISTICS:
            <thead>
            <tr>
                <th>PLAYER NAME:</th>
                <th>GAME:</th>
                <th>WIN:</th>
                <th>GAME OVER:</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <%=account.getName()%>
                </td>
                <td>
                    <%=account.getPlayCount()%>
                </td>
                <td>
                    <%=account.getWinCount()%>
                </td>
                <td>
                    <%=account.getGameOverCount()%>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
