package commerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().println("Not possible !!!!");
		        Connection con = null;
		        PreparedStatement ps = null;
		        PreparedStatement ps2 = null;

		        try {

		            con = DBConnection.getConnection();
		            HttpSession session = request.getSession();
		            int userId = (int)session.getAttribute("userId");

		            String query =
		            	"INSERT INTO orders(user_id, product_name, price) " +
		                "SELECT ?, p.name, p.price " +
		                "FROM cart c JOIN product p ON c.product_id = p.id " +
		                "WHERE c.user_id=?";
		            
		            ps = con.prepareStatement(query);

		            ps.setInt(1, userId);
		            ps.setInt(2, userId);
		            
		            int i = ps.executeUpdate();


		            if (i > 0) {

		                ps2 = con.prepareStatement("DELETE FROM cart where user_id=?");
		                ps2.setInt(1, userId);

		                ps2.executeUpdate();

		                response.sendRedirect("Orders.jsp");
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		            response.getWriter().println("Error: " + e.getMessage());
		        }
		    }
		}
