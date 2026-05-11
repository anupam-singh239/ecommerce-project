package commerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		        try {

		            String product =
		            request.getParameter("product");

		            int rating =
		            Integer.parseInt(
		            request.getParameter("rating"));
		            
		            String review = request.getParameter("review");

		            Connection con =
		            DBConnection.getConnection();

		            PreparedStatement ps =
		            con.prepareStatement(
		            "insert into rating(product, rating, review) values(?, ?, ?)");

		            ps.setString(1, product);
		            ps.setInt(2, rating);
		            ps.setString(3, review);

		            ps.executeUpdate();

		            response.sendRedirect("Orders.jsp");

		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
