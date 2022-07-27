<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MARKETPLACE</h1>
<hr>
<h4>Product details</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Product name: </b>${product.name}<br>
<b>Product description: </b>${product.description}<br>
<b>Product price: </b>${product.price}<br>
<b>City: </b>${product.city}<br>
<b>Seller: </b><a href="/user/${product.user.id}"> ${product.user.name}</a><br>
</body>
</html>