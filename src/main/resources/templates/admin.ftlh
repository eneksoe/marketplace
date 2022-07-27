<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MARKETPLACE</h1><hr>
<h4>Admin Panel</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Phone number</th>
        <th>Active</th>
        <th>Role</th>
        <th>Ban</th>
        <th>User info</th>
        <th>Edit user</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th>${user.active?c}</th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban">
                </form> </th>
            <th><a href="/admin/user/edit/${user.id}">Edit user</a></th>
            <th><a href="/user/${user.id}">User info</a></th>
        </tr>
        <#else>
        <h3>No users</h3>
    </#list>
</body>
</html>