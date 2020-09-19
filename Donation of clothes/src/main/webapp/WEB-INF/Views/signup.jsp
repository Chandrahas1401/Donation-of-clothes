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
	color:white;
	font-size:2.5em;
	font-family: "Times New Roman", Times, serif;
}
div
{
    background-color:rgba(255, 192, 117, 0.5);
	margin: 0px 500px 0px 600px;
	width: 700px;
    padding: 25px;
	
}
</style>
</head>
<body>
<form action="/signup.do" method="post">
<div>
<h1 style="text-align:center">Sign Up!</h1>

<p style="font-size: 70%">Project: Orion Jade is an initiative to connect charities and NGOs with those who are willing to donate. 
The first phase of this project supports the donation of clothes to the charity of the user's choosing.

By registering as a user, you accept the moral terms and conditions.
</p>

<pre>
Username: <input type="text" name="user">
Password: <input type="password" name="password">
First Name: <input type="text" name="fname">
Last Name: <input type="text" name="lname">
E-mail ID: <input type="text" name="email">
Address: <input type="text" name="address">
Phone Number: <input type="text" name="num">

<input type="submit" value="Sign Up">
<br>
</pre>
</div>
</form>
</body>
</html>