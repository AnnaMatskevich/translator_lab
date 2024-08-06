<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Requests history</title>

    <div class = "container mt-5 mb-5">
        <form action="/mytranslator" method = "get">
            <button type="submit" class="btn btn-success">back</button>
        </form>
    </div>

</head>
<body>
<h1>Requests history</h1>

<table border="1">
    <thead>
    <tr>
        <th>User_IP</th>
        <th>Request</th>
        <th>Answer</th>
    </tr>
    </thead>
    <tbody>
    <#list requests as request>
        <tr>
            <td>${request.userIp}</td>
            <td>${request.request}</td>
            <td>${request.answer}</td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
