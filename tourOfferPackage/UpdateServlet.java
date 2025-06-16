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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(UpdateServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("GET request received in UpdateServlet – no logic implemented.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request received for updating an offer.");

     // Retrieve input values from the request parameters
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String stdate = request.getParameter("stdate");
        String edate = request.getParameter("edate");

        logger.info("Updating offer ID " + id + " with title: " + title);

     // Call the controller method to update the offer data in the database
        boolean isTrue = offerController.updatedata(id, title, description, price, discount, stdate, edate);

        if (isTrue) {
        	// If update was successful, retrieve the updated data and set it as a request attribute
            logger.info("Offer updated successfully for ID: " + id);
            List<offerModel> offerdetails = offerController.getById(id);
            request.setAttribute("offerdetails", offerdetails);

         // Display success message using JavaScript alert and redirect to Offergetall
            String alartMessage = "Data update is Succesfull";
            response.getWriter().println("<script> alert('" + alartMessage + "'); window.location.href='Offergetall'</script>");
        } else {
            logger.warning("Failed to update offer ID: " + id);
         // If update failed, log a warning and forward to wrong.jsp
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}