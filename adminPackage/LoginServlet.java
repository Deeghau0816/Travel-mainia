package adminPackage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger to record login activity
    private static final Logger logger = LoggerUtil.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request received for admin login.");
        
        // Get login credentials from the request
        String gmail = request.getParameter("gmail");
        String password = request.getParameter("password");

        logger.info("Attempting login for: " + gmail);

        try {
        	// Call controller to validate credentials
            List<AdminModel> adminlogin = AdminController.loginValidate(gmail, password);

             // If credentials are valid
            if (!adminlogin.isEmpty()) {
                HttpSession session = request.getSession();
                session.setAttribute("adminEmail", gmail);
                session.setAttribute("adminObject", adminlogin.get(0));

                logger.info("Login successful for: " + gmail);
                
             // Forward to the admin dashboard or main page
                request.setAttribute("adminlogin", adminlogin);
                RequestDispatcher dis = request.getRequestDispatcher("Offergetall");
                dis.forward(request, response);
            } else {
            	// Invalid credentials – show error message and redirect to login page
                logger.warning("Login failed for: " + gmail);
                request.setAttribute("errorMessage", "Invalid Gmail or Password");
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            }
        } catch (Exception e) {
        	
        	// Log and throw any unexpected error
            logger.severe("Login error: " + e.toString());
            throw new ServletException("Login failed due to server error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request received on LoginServlet – not supported.");
    }
}
