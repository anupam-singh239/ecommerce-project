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
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		        try {
		            Connection con = DBConnection.getConnection();

		            HttpSession session = request.getSession(false);

		            if(session == null || session.getAttribute("userId") == null) {
		                response.sendRedirect("Login.jsp");
		                return;
		            }

		            int userId = (int) session.getAttribute("userId");

		            String action = request.getParameter("action");
		            int pid = Integer.parseInt(request.getParameter("id"));

		            if(action.equals("add")) {

		                PreparedStatement ps = con.prepareStatement(
		                    "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,1)"
		                );

		                ps.setInt(1, userId);
		                ps.setInt(2, pid);
		                ps.executeUpdate();
		            }

		            if(action.equals("remove")) {

		                PreparedStatement ps = con.prepareStatement(
		                    "DELETE FROM cart WHERE user_id=? AND product_id=?"
		                );

		                ps.setInt(1, userId);
		                ps.setInt(2, pid);
		                ps.executeUpdate();
		            }

		            response.sendRedirect("Cart.jsp");

		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		
		}