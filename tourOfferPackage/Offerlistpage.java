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

@WebServlet("/Offerlistpage")
public class Offerlistpage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(Offerlistpage.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request received for offer list page.");

        try {
        	 // Retrieve all tour offers using the controller
            List<offerModel> offerList = offerController.getalloffer();
            logger.info("Number of offers retrieved: " + offerList.size());

         // Set the offer list as a request attribute so it can be accessed in the JSP
            request.setAttribute("offerList", offerList);
         // Forward the request and response to the offerslist.jsp page 
            RequestDispatcher dispatcher = request.getRequestDispatcher("offerslist.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.severe("Error retrieving offer list: " + e.toString());
            throw new ServletException("Could not load offer list", e);
        }
    }
}