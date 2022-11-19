<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/logic" method="POST">
        <%String accountName = (String) request.getAttribute("account_name");%>
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
        <input type="hidden" name="account_name" value="<%=accountName%>">
        <h3><%=accountName%>
        </h3>
        <a href="login.jsp">LOG OUT</a>
    </form>
</div>

</body>
</html>
