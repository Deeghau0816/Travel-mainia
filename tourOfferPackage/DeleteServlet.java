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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(DeleteServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request received on DeleteServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request received to delete offer.");

        //catch the parameters from form
        String id = request.getParameter("id");
        logger.info("Attempting to delete offer with ID: " + id);

     // Call controller to delete the offer with the given ID
        boolean isTrue = offerController.deletedata(id);

        if (isTrue) {
        	// If deletion was successful
            logger.info("Offer deleted successfully: ID " + id);
            String alartMessage = "Data delete Successfully";
         // Send JavaScript alert and redirect to offer listing page
            response.getWriter().println("<script> alert('" + alartMessage + "'); window.location.href='Offergetall'</script>");
        } else {
            logger.warning("Failed to delete offer with ID: " + id);
         // Get offer details by ID to potentially display in error page
            List<offerModel> offerDetails = offerController.getById(id);
            request.setAttribute("offerDetails", offerDetails);

            //forward to error page
            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
            dispatcher.forward(request, response);
        }
    }
}