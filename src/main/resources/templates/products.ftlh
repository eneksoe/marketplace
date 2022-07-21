<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MARKETPLACE</h1>
<hr>
<h4>Simple to bay, simple to sell</h4>
<#list products as product>
    <div>
        <p><b>${product.name}</b> ${product.price} eur <a href="/product/${product.id}">More...</a></p>
    </div>
</#list>
<hr>
<h3>Create new product</h3>
<form action="/product/create" method="post">
    Product name: <input type="text" , name="name"/><br><br>
    Product description: <input type="text" , name="description"/><br><br>
    Product price: <input type="text" , name="price"/><br><br>
    City: <input type="text" , name="city"/><br><br>
    Seller: <input type="text" , name="seller"/><br><br>
    <input type="submit" value="add"/>
</form>
</body>
</html>