<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial;
}

body{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
background:linear-gradient(to right,#ff416c,#ff4b2b);
}

.container{
width:380px;
background:white;
padding:35px;
border-radius:10px;
box-shadow:0 0 15px rgba(0,0,0,0.3);
}

.container h1{
text-align:center;
margin-bottom:20px;
}

.input-box{
width:100%;
padding:12px;
margin:10px 0;
border:1px solid #ccc;
border-radius:5px;
outline:none;
}

.btn{
width:100%;
padding:12px;
background:#ff416c;
color:white;
border:none;
border-radius:5px;
font-size:16px;
cursor:pointer;
margin-top:10px;
}

.btn:hover{
background:#e63a5f;
}

.link{
text-align:center;
margin-top:15px;
}

.link a{
text-decoration:none;
color:#ff416c;
font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

<h1>Login Form</h1>

<form action="Login" method="post">
<input type="text"
name="emailOrMobile"
placeholder="Email or Mobile Number"
class="input-box"
required>

<input type="password"
name="password"
placeholder="Password"
class="input-box"
required>

<button type="submit" class="btn">
Login
</button>

</form>

<div class="link">

Don't have account?
<a href="Signup.jsp">Signup</a>

</div>

</div>

</body>
</html>