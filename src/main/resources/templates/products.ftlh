<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MARKETPLACE</h1><hr>
<#if user.email??>
    <h3>User Name: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="LogOut">
    </form>
<#else>
    <a href="/login">SingIn</a></h1>
</#if>
<hr>
<h4>Simple to bay, simple to sell</h4>
<form action="/" method="get">
    Search by product name: <input type="text" name="name">
    <input type="submit" value="Search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.name}</b> ${product.price} eur <a href="/product/${product.id}">More...</a></p>
    </div>
<#else>
    <h3>No product</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Create new product</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Product name: <input type="text" name="name"/><br><br>
        Product description: <input type="text" , name="description"/><br><br>
        Product price: <input type="text" name="price"/><br><br>
        City: <input type="text" name="city"/><br><br>
        First photo: <input type="file" name="file1"/><br><br>
        Second photo: <input type="file" name="file2"/><br><br>
        Third photo: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="add"/>
    </form>
</#if>
</body>
</html>