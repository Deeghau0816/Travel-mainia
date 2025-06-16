package servlets;

import java.io.IOException;
import model.Contactus;
import services.ContactusServices;
import services.LoggerUtil;
import java.sql.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contactus;
import services.ContactusServices;

import java.io.IOException;

@WebServlet("/deletemsg")
public class deletemsg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(deletemsg.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Get email parameter to identify message to delete
    	String email = request.getParameter("email");
       
    	// Create Contactus object with email set
    	Contactus cs = new Contactus();
        cs.setEmail(email);

        // Log delete request
        logger.info("Delete request for contact message: " + email);

        // Call service to delete message from database
        ContactusServices serv = new ContactusServices();
        serv.delet(cs);

        RequestDispatcher disp = request.getRequestDispatcher("ReadData");
        disp.forward(request, response);
    }
}
