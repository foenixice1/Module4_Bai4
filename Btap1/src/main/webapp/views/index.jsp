<%--
  Created by IntelliJ IDEA.
  User: iU LOVE
  Date: 16/08/2021
  Time: 7:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gmail</title>
</head>
<body>
=<%--@elvariable id="email" type="com"--%>
<form:form modelAttribute="email" action="/create" method="post">
    <table>
        <tr>
            <td>Languages :</td>
            <td><form:select path="languages" items="${languagesArray}"/></td>
        </tr>

        <tr>
            <td>Page size :</td>
            <td>Show <form:select path="size" items="${sizeArray}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams fillter :</td>
            <td><form:checkbox path="spam" items="${spamArray}"/> Enable spams fillter </td>
        </tr>
        <tr>
            <td>Signature :</td>
            <td><form:textarea path="signature"/> </td>
        </tr>
        <tr>
            <td><button type="submit" value="Update"/></td>
            <td><button type="reset" value="Cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
