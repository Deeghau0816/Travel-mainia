package adminPackage;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminInsertServlet")
public class AdminInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(AdminInsertServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request received for admin registration.");

        String name = request.getParameter("name");
        String gmail = request.getParameter("gmail");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        logger.info("Admin data received: " + gmail);

     // Calling controller method to insert the admin into the database
        boolean isTrue = AdminController.insertdata(name, gmail, password, phone);

        
     // If insertion fails, forward to an error page
        if (isTrue) {
            logger.info("Admin registered successfully: " + gmail);
            String alartMessage = "Register Successful";
            response.getWriter().println("<script> alert('" + alartMessage + "'); window.location.href='Offergetall'</script>");
        } else {
        	// If insertion fails, forward to an error page
            logger.warning("Admin registration failed: " + gmail);
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}
