package RegisterPack;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.logging.Logger;

@WebServlet("/DvpUserDeleteServlet")
public class DvpUserDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 // Logger to track user deletion actions
    private static final Logger logger = LoggerUtil.getLogger(DvpUserDeleteServlet.class);

    // Handle user deletion request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        logger.info("Delete request received for user ID: " + userId);

        //delete user detail according to the UserId
        boolean isTrue = RegController.userDelete(userId);

        if (isTrue) {
        	// Deletion successful, alert and redirect to login page
            logger.info("User deleted successfully: ID=" + userId);
            response.getWriter().println("<script>alert('Your account has been deleted!'); window.location.href='DvpLogin.jsp'</script>");
        } else {
        	// Deletion failed, show error page
            logger.warning("Failed to delete user ID: " + userId);
            List<RegModel> deleteAcc = RegController.getById(userId);
            request.setAttribute("deleteAcc", deleteAcc);

            RequestDispatcher deleteDsp = request.getRequestDispatcher("wrong.jsp");
            deleteDsp.forward(request, response);
        }
    }
}
