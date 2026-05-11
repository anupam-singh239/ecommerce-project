<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<title>Rating</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="form-box">

<h2>Give Rating</h2>

<form action="RatingServlet" method="post">

<input type="text"
name="product"
placeholder="Product Name">

<br>

<input type="number"
name="rating"
placeholder="Rating"
min="1"
max="5">

<br><br>
<br><br>

<textarea name="review"
placeholder="Write Review"></textarea>

<br><br>
<input type="submit"
value="Submit Rating">

</form>

</div>

</body>
</html>