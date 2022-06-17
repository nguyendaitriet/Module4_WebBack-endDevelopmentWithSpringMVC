
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <form action="/lookup" method="post">
        <input type="text" name="inputWord" value="${inputWord}">
        <p>Result</p>
        <input type="text" name="result" value="${result}">
        <button type="submit">Translate</button>
    </form>
</body>
</html>
