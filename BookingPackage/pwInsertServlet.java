package BookingPackage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwInsertServlet")
public class pwInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for logging actions and errors
    private static final Logger logger = LoggerUtil.getLogger(pwInsertServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String date = request.getParameter("date");
        String guide = request.getParameter("guide");
        String numofpeople = request.getParameter("numofpeople");

        logger.info("Booking insert request received for: " + name);

        // Call the control layer to insert booking
        boolean isTrue = BookingControl.insertdata(name, place, date, guide, numofpeople);

        if (isTrue) {
        	// If insertion successful, show success alert and redirect
        	logger.info("Booking inserted successfully for: " + name);
            response.getWriter().println("<script> alert('Data insert Successful'); window.location.href ='pwGetAllServlet'</script>");
        } else {
        	// If insertion fails, forward to error page
        	logger.warning("Booking insert failed for: " + name);
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}
