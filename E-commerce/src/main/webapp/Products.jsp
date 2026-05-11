<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="commerce.DBConnection" %>
<%@ page import="java.sql.*" %>
<style>

.container{
    display:flex;
    flex-wrap:wrap;
    gap:20px;
}

.product{
    width:220px;
    border:1px solid #ccc;
    padding:15px;
    text-align:center;
    border-radius:10px;
}

.product img{
    width:180px;
    height:180px;
    object-fit:cover;
}

</style>

<div style="background:blue; color:white; padding:10px;">
    Welcome <%= session.getAttribute("name") %> |

    <a href="<%= request.getContextPath() %>/Products.jsp" style="color:white;">
        Home
    </a> |

    <a href="<%= request.getContextPath() %>/Cart.jsp" style="color:white;">
        Cart
    </a> |

    <a href="<%= request.getContextPath() %>/Logout" style="color:white;">
        Logout
    </a>
</div>
 <div style="text-align:center;margin-top:30px;">
   <h1>WLECOME</h1>
   <img src="images/logo.png" width="200">
<%

/* Session check */
if(session.getAttribute("userId") == null){
    response.sendRedirect("Login.jsp");
    return;
}

/* DB connection */
Connection con = DBConnection.getConnection();

/* Query */
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM product");
%>

<div class="navbar">
Welcome <%= session.getAttribute("userName") %> |
<a href="Cart.jsp" style="color:white;">Cart</a>
</div>

<div class="container">

<%
while(rs.next()){
%>

<div class="product">

    <img src="<%= request.getContextPath()%>/images/<%= rs.getString("image") %>" width="150"height="150">

    <h3><%= rs.getString("name") %></h3>

    <p>₹<%= rs.getInt("price") %></p>

    <a href="Cart?action=add&id=<%= rs.getInt("id") %>">
        Add to Cart
    </a>
    
<form action="PlaceOrderServlet" method="post">
    <input type="hidden" name="productId" 
           value="<%= rs.getInt("id") %>">
    
</form>
</div>

<%
}
%>

</div>