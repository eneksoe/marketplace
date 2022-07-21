<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MARKETPLACE</h1>
<hr>
<h4>Product details</h4>
<b>Product name: </b>${product.name}<br>
<b>Product description: </b>${product.description}<br>
<b>Product price: </b>${product.price}<br>
<b>City: </b>${product.city}<br>
<b>Seller: </b>${product.seller}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="delete product"/>
</form>
</body>
</html>