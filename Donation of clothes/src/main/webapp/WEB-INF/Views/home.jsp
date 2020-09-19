<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<style>
body
{
	background: url(https://www.rd.com/wp-content/uploads/2018/02/wjhat-really-happens-to-our-used-clothing.jpg);
	background-repeat: no-repeat;
	background-size: 1920px 1020px;
	font-size:2.5em;
	font-family: "Times New Roman", Times, serif;
}
pre
{
	background-color:rgba(255, 192, 117, 0.5);
	font-size:0.7em;
}
div
{
	margin: 20px 0px 200px 0px;
		
}
</style>
</head>
<body>
<form action="/home.do" method="post">
	<nav class="navbar navbar-default">

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Donate</a></li>
			<li><a href="/orders.do">Orders</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">Logout</a></li>
		</ul>

	</nav>
<pre>
<div class="container">
<h1>Welcome ${name}</h1>
<br>
Thank you for choosing our service. Upon completion, you will have surely changed the lives of many.
Please select the type and quantity of clothes you would like to donate:
<br>
Shirts:  <input type="number" name="shirts" value=0 min="0">
<br>
Shoes:   <input type="number" name="shoes" value=0 min="0">
<br>
Pants:   <input type="number" name="pants" value=0 min="0">
<br>
Dresses: <input type="number" name="dresses" value=0 min="0">
<br>
Others:  <input type="number" name="others" value=0 min="0">
<br>
<input type="submit" value="Submit">
</div>
</pre>
</form>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>