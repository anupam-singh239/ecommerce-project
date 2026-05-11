<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>
<%@ page import="commerce.DBConnection" %>

<title>Orders</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">
<div style="text-align:center; margin-bottom:20px;">

<h2>Your Orders</h2>
<table style="width:100%; border-collapse:collapse;">
<tr>
<th>Product</th>
<th>Price</th>
<th>Order Date</th>
<th>Rating</th>
<th>Action</th>
</tr>

<%

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("select * from orders");

ResultSet rs = ps.executeQuery();

while(rs.next()) {

%>

<tr>

<td>
<%= rs.getString("product_name") %>
</td>

<td>
₹<%= rs.getInt("price") %>
</td>
<td><%= rs.getString("order_date") %></td>

<td>
<a href="Rating.jsp">Give Rating</a>
</td>
<td>
    <a href="DeleteOrder?id=<%= rs.getInt("id") %>">
        Delete
    </a>
</td>
</tr>

<%
}
%>

</table>
<div style="text-align:center; margin-top:20px;">
    <a href="Products.jsp"
    style="padding:10px 20px;
    background:blue;
    color:white;
    text-decoration:none;
    border-radius:5px;">
    Home
    </a>
</div>

</div>

</body>
</html>
