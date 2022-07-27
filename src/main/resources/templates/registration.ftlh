<!DOCTYPE html>
<html>
<head>
    <title>MARKETPLACE</title>
</head>
<body>
<h1>MARKETPLACE</h1>
<h4>SingUp</h4>
<form action="/registration" method="post">
    User Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Phone Number: <input type="text" name="phoneNumber"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="SingUp"/>
</form>
<#if errorMessage??>
    <h2 style="...">${errorMessage}</h2>
</#if>
</body>
</html>