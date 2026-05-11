<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="commerce.DBConnection" %>
<%@ page import="java.sql.*" %>

<link rel="stylesheet" href="style.css">

<div class="navbar">Your Cart</div>

<div class="cart-box">

<%
Connection con = DBConnection.getConnection();

Integer userId = (Integer)
session.getAttribute("userId");
if(userId==null){
	response.sendRedirect("Login.jsp");
	return ;
}

PreparedStatement ps = con.prepareStatement(
"SELECT p.name,p.price,p.id FROM cart c JOIN product p ON c.product_id=p.id WHERE c.user_id=?"
);

ps.setInt(1, userId);

ResultSet rs = ps.executeQuery();

int total = 0;

while(rs.next()){
    total += rs.getInt("price");
%>

<div>
    <%= rs.getString("name") %> - ₹<%= rs.getInt("price") %>

    <a href="Cart?action=remove&id=<%= rs.getInt("id") %>">
        Remove
    </a>
</div>

<% } %>

<h3>Total: ₹<%= total %></h3>
<br><br>

<form action="PlaceOrderServlet" method="post">

<input type="submit" value="Place Order">

</form>

</div>