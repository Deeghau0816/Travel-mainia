package RegisterPack;

import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DvpUserUpdateServlet")
public class DvpUserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

     // Logger for update user profile
    private static final Logger logger = LoggerUtil.getLogger(DvpUserUpdateServlet.class);

    // Handle profile
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dobString = request.getParameter("dob");
        String password = request.getParameter("password");

     // Convert date string to SQL Date
        Date dob = Date.valueOf(dobString);

        logger.info("Update request for user ID: " + userId);

     // Update user profile in DB
        boolean isTrue = RegController.updateProfile(userId, name, userName, phone, email, dob, password);

        if (isTrue) {
            logger.info("User updated successfully: " + userName);
            List<RegModel> userUpdating = RegController.getById(userId);
            
            // Update session
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            if (!userUpdating.isEmpty()) {
                session.setAttribute("register", userUpdating.get(0));
            }

            request.setAttribute("userUpdating", userUpdating);
            response.getWriter().println("<script>alert('Your data has been Updated!'); window.location.href='DvpHome-log.jsp'</script>");
        } else {
        	// Update failed, forward to error page
            logger.warning("Failed to update user ID: " + userId);
            RequestDispatcher updateDsp = request.getRequestDispatcher("wrong.jsp");
            updateDsp.forward(request, response);
        }
    }
}
