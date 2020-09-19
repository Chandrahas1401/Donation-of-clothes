<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project: Orion Jade</title>
<style>
body
{
	background: url(https://www.rd.com/wp-content/uploads/2018/02/wjhat-really-happens-to-our-used-clothing.jpg);
	background-repeat: no-repeat;
	background-size: 1920px 1020px;
	text-align:center;
	color:white;
	margin: 200px 0px 200px 0px;
	font-family: "Times New Roman", Times, serif;
}
pre
{
    background-color:rgba(255, 192, 117, 0.5);

}
a
{
	color: lightgreen;
	font-size: 1.5em
}
</style>
</head>
<body>
<form action="/welcome.do" method="post">

<pre style="font-size:170%">
<p style="font-size: 4.5em";>Project: Orion Jade</p>
Welcome to Project: Orion Jade. Please login...
<br>
<p><font color="red">${error}</font></p>
Username: <input type="text" name="name">
Password: <input type="password" name="password">
<input type="submit" value="Login">
<br>
<br>
<a href="http://localhost:8080/signup.do"><b>First time visiting? Welcome! You can sign up by clicking here.</b></a>
</pre>
</form>
</body>
</html>