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

@WebServlet("/pwGetAllServlet")
public class pwGetAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for logging actions and errors
    private static final Logger logger = LoggerUtil.getLogger(pwGetAllServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Fetching all bookings.");
        List<BookingModel> allBookings = BookingControl.getAllBooking();
        logger.info("Total bookings fetched: " + allBookings.size());

        request.setAttribute("allBookings", allBookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayBooking.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
