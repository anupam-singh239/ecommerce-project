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
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		        try {

		            int id = Integer.parseInt(request.getParameter("id"));

		            Connection con = DBConnection.getConnection();

		            PreparedStatement ps =
		                    con.prepareStatement("delete from orders where id=?");

		            ps.setInt(1, id);

		            ps.executeUpdate();

		            response.sendRedirect("Orders.jsp");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

