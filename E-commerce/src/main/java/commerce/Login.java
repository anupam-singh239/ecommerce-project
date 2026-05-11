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
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		        try {
		            Connection con = DBConnection.getConnection();

		            String emailOrMobile = request.getParameter("emailOrMobile");
		            String password = request.getParameter("password");

		            PreparedStatement ps = con.prepareStatement(
		                "SELECT * FROM users WHERE (email=? OR mobile=?) AND password=?"
		            );

		            ps.setString(1, emailOrMobile);
		            ps.setString(2, emailOrMobile);
		            ps.setString(3, password);

		            ResultSet rs = ps.executeQuery();

		            if(rs.next()) {

		                HttpSession session = request.getSession();
		                int id = rs.getInt("id");

		                session.setAttribute("userId", rs.getInt("id"));
		                session.setAttribute("name", rs.getString("first_name"));

		                response.sendRedirect("Products.jsp");

		            } else {
		                response.getWriter().println("Invalid Login!");
		            }

		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		}