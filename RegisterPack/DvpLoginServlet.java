package RegisterPack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.logging.Logger;

@WebServlet("/DvpLoginServlet")
public class DvpLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for login events
    private static final Logger logger = LoggerUtil.getLogger(DvpLoginServlet.class);

    // Handle login request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        logger.info("Login attempt for user: " + userName);

        try {
        	// Validate user credentials
            List<RegModel> login = RegController.loginValidate(userName, password);

            if (login != null && !login.isEmpty()) {
            	
            	// After a Successful login, it creates a session
                HttpSession session = request.getSession();
                session.setAttribute("userName", userName);
                session.setAttribute("register", login.get(0));

                logger.info("Login successful for user: " + userName);
                response.getWriter().println("<script>alert('Login Successful!'); window.location.href='DvpHome-log.jsp'</script>");
            } else {
            	
            	// Login failed alert
                logger.warning("Login failed for user: " + userName);
                response.getWriter().println("<script>alert('Invalid LogIn! Try again!!'); window.location.href='DvpLogin.jsp'</script>");
            }
        } catch (Exception e) {
        	// Login error
            logger.severe("Login error for user " + userName + ": " + e.toString());
            e.printStackTrace();
        }
    }
}
