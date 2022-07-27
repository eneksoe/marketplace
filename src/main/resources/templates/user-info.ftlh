<!DOCTYPE html>
<html>
<head>
    <title>MARKETPLACE</title>
</head>
<body>
<h1>MARKETPLACE</h1>
<h3>Seller Info ${user.name}</h3>
<b>Phone number: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<h4>Sellers Products ${user.name}</h4>
<#list products as product>
    <div>
        <p><b>${product.name}</b> ${product.price} eur <a href="/product/${product.id}">More...</a></p>
    </div>
<#else>
    <h3>No Products</h3>
</#list>
<#if errorMessage??>
    <h2 style="...">${errorMessage}</h2>
</#if>
</body>
</html>