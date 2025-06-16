package BookingPackage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwDeleteServlet")
public class pwDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for logging actions and errors
    private static final Logger logger = LoggerUtil.getLogger(pwDeleteServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Get the booking ID from request parameters
    	String id = request.getParameter("id");
        logger.info("Delete request received for booking ID: " + id);

        // Attempt to delete the booking
        boolean isTrue = BookingControl.deletedata(id);

        if (isTrue) {
        	// If deletion is successful, show alert and redirect to list page
            logger.info("Booking deleted successfully: ID=" + id);
            response.getWriter().println("<script>alert('Booking cancel Successful'); window.location.href='pwGetAllServlet';</script>");
        } else {
        	// If deletion fails, fetch booking details and forward to error page
        	logger.warning("Failed to delete booking: ID=" + id);
            List<BookingModel> bookingDetails = BookingControl.getById(id);
            request.setAttribute("bookingDetails", bookingDetails);
            RequestDispatcher dispacher = request.getRequestDispatcher("wrong.jsp");
            dispacher.forward(request, response);
        }
    }
}
