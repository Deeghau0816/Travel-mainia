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

@WebServlet("/pwUpdateServlet")
public class pwUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for logging actions and errors
    private static final Logger logger = LoggerUtil.getLogger(pwUpdateServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String date = request.getParameter("date");
        String guide = request.getParameter("guide");
        String numofpeople = request.getParameter("numofpeople");

        logger.info("Update request for booking ID: " + id);

        // Call the control layer to update booking
        boolean isTrue = BookingControl.updatedata(id, name, place, date, guide, numofpeople);

        if (isTrue) {
            logger.info("Booking updated successfully: ID=" + id);
            List<BookingModel> bookingdetails = BookingControl.getById(id);
            request.setAttribute("bookingdetails", bookingdetails);
            response.getWriter().println("<script> alert('Booking Edit Successful'); window.location.href ='pwGetAllServlet'</script>");
        } else {
            logger.warning("Failed to update booking: ID=" + id);
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}
