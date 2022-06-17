<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16-Jun-22
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calculator" method="post">
        <input type="number" name="value" value="${value}">
        <p>Result</p>
        <input type="number" name="result" value="${result}">
        <select name="choice">
            <option value="1">VND -> USD</option>
            <option value="2">USD -> VND</option>
        </select>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
