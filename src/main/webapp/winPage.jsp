<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="css/aliens.css">
    <title></title>
</head>

<body>
<%Account account = (Account) session.getAttribute("account");%>
<%account.setWinCount(account.getWinCount() + 1);%>
<div class="bg_win_page">
    <form action="<c:url value="/home.jsp"/>">
        <h1>You win</h1>
        <input type="submit"
               value="PLAY AGAIN"/>
        <input type="hidden" name="account_name" value="<%=account.getName()%>">
        <%account.setPlayCount(account.getPlayCount() + 1);%>
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
