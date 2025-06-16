package tourOfferPackage;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(insertServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("POST request received to insert offer.");

     // Extract all offer parameters from the request
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String stdate = request.getParameter("stdate");
        String edate = request.getParameter("edate");

        logger.info("Collected offer data: Title=" + title + ", Price=" + price + ", Dates=" + stdate + " to " + edate);

     // Call controller to insert the new offer into the database
        boolean isTrue = offerController.insertdata(title, description, price, discount, stdate, edate);

        if (isTrue) {
            logger.info("Offer inserted successfully: " + title);
            String alartMessage = "Data insert is Succesfull";
         // Send JavaScript alert to user and redirect to offer listing page
            response.getWriter().println("<script> alert('" + alartMessage + "'); window.location.href='Offergetall'</script>");
        } else {
            logger.warning("Failed to insert offer: " + title);
         // Forward to error page
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}