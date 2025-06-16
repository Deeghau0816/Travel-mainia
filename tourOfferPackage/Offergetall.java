package tourOfferPackage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Offergetall")
public class Offergetall extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(Offergetall.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request received to fetch all offers.");

        try {
        	// Retrieve all offers from the controller
            List<offerModel> alloffers = offerController.getalloffer();
            logger.info("Total offers fetched: " + alloffers.size());

            // Set offers list as request attribute for the view
            request.setAttribute("alloffers", alloffers);
         // Forward to display page
            RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.severe("Error fetching offers in Offergetall servlet: " + e.toString());
            throw new ServletException("Error loading offers", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request redirected to GET handler.");
        doGet(request, response);
    }
}