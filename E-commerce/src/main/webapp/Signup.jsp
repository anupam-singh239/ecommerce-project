<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

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
background:linear-gradient(to right,#8e2de2,#4a00e0);
}

.container{
width:400px;
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
margin:8px 0;
border:1px solid #ccc;
border-radius:5px;
outline:none;
}

.btn{
width:100%;
padding:12px;
background:#4a00e0;
color:white;
border:none;
border-radius:5px;
font-size:16px;
cursor:pointer;
margin-top:10px;
}

.btn:hover{
background:#3500b3;
}

.link{
text-align:center;
margin-top:15px;
}

.link a{
text-decoration:none;
color:#4a00e0;
font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

<h1>Signup Form</h1>

<form action="Signup" method="post">

<input type="text"
name="firstname"
placeholder="First Name"
class="input-box"
required>

<input type="text"
name="lastname"
placeholder="Last Name"
class="input-box"
required>

<input type="email"
name="email"
placeholder="Email Address"
class="input-box"
required>

<input type="text"
name="mobile"
placeholder="Mobile Number"
class="input-box"
required>

<select name="gender" class="input-box" required>

<option value="">Select Gender</option>
<option>Male</option>
<option>Female</option>
<option>Other</option>

</select>

<input type="date"
name="dob"
class="input-box"
required>

<input type="password"
name="password"
placeholder="Password"
class="input-box"
required>

<button type="submit" class="btn">
Signup
</button>

</form>

<div class="link">

Already have account?
<a href="Login.jsp">Login</a>

</div>

</div>

</body>
</html>