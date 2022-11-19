<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String accountName = (String) request.getAttribute("account_name");%>
<%String wrongAnswerDescription = (String) request.getAttribute("wrong_answer_description");%>

<form action="/login" method="get">
    <p><%=wrongAnswerDescription%>
    </p>
    <input type="submit" value="RESTART GAME"/>
    <input type="hidden" name="account_name" value="<%=accountName%>">
    <h3><%=accountName%>
    </h3>
    <a href="login.jsp">LOG OUT</a>
</form>
</body>
</html>
