package adminPackage;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for logging logout events
    private static final Logger logger = LoggerUtil.getLogger(LogoutServlet.class);

    //handle login, logout requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request to logout.");

     // Sessions
        HttpSession session = request.getSession(false); // don't create if it doesn't exist
        if (session != null) {
            logger.info("Session invalidated for user.");
            session.invalidate(); // destroy session
        } else {
        	// If no session exists, log a warning
            logger.warning("No session found during logout.");
        }

        response.sendRedirect("DvpHome.jsp");
    }
}
