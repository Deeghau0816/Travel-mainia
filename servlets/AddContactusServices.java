package servlets;

import model.Contactus;
import services.ContactusServices;
import services.LoggerUtil;

import java.io.IOException;
import java.sql.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Handles new contact message
@WebServlet("/AddContactusServices")
public class AddContactusServices extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(AddContactusServices.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Get parameters from form
    	String email = request.getParameter("email");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String msg = request.getParameter("msg");
        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr);

        // Create Contact-us object and set fields
        Contactus contact = new Contactus();
        contact.setEmail(email);
        contact.setName(name);
        contact.setCountry(country);
        contact.setMsg(msg);
        contact.setDate(date);

        // Log the received contact message
        logger.info("Received contact submission from: " + email);

        // Save message using service class
        ContactusServices service = new ContactusServices();
        service.addMsg(contact);

        response.sendRedirect("Contactus.jsp");
    }
}
