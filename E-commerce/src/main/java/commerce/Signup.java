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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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

		            String fname = request.getParameter("fname");
		            String lname = request.getParameter("lname");
		            String dob = request.getParameter("dob");
		            String gender = request.getParameter("gender");
		            String mobile = request.getParameter("mobile");
		            String email = request.getParameter("email");
		            String password = request.getParameter("password");

		            PreparedStatement ps = con.prepareStatement(
		                "INSERT INTO users(first_name,last_name,dob,gender,mobile,email,password) VALUES(?,?,?,?,?,?,?)"
		            );

		            ps.setString(1, fname);
		            ps.setString(2, lname);
		            ps.setString(3, dob);
		            ps.setString(4, gender);
		            ps.setString(5, mobile);
		            ps.setString(6, email);
		            ps.setString(7, password);

		            ps.executeUpdate();

		            response.sendRedirect("Login.jsp");

		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

