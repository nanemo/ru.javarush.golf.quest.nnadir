<%--
  Created by IntelliJ IDEA.
  User: nnbak
  Date: 11/16/2022
  Time: 2:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You win</title>
</head>
<body>
<%String accountName = (String) request.getAttribute("account_name");%>
<form action="/login" method="GET">
    <h1>You win</h1>
    <input type="submit"
           value="PLAY AGAIN"/>
    <input type="hidden" name="account_name" value="<%=accountName%>">
    <h3><%=accountName%>
    </h3>
    <a href="login.jsp">LOG OUT</a>
</form>
</body>
</html>
