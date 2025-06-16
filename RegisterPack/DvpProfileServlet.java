package RegisterPack;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DvpProfileServlet")
public class DvpProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 // Logger for profile access
    private static final Logger logger = LoggerUtil.getLogger(DvpProfileServlet.class);

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Logged in user profile session
    	RegModel register = (RegModel) request.getSession().getAttribute("register");

        if (register != null) {
        	// User logged in, forward to profile page
            logger.info("Profile access for user: " + register.getUserName());
            request.setAttribute("register", register);
            request.getRequestDispatcher("DvpUserProfile.jsp").forward(request, response);
        } else {
            logger.warning("Unauthorized profile access attempt.");
            response.sendRedirect("Homeeeee.jsp");
        }
    }

 // Handle GET type request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
 // Handle POST type request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
