package servlets;

import java.io.IOException;
import java.io.IOException;
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
import java.sql.Date;

//Handles contact message updates
@WebServlet("/updateContact")
public class updateContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Logger for tracking updates
    private static final Logger logger = LoggerUtil.getLogger(updateContact.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Get form data and populate model
    	Contactus cs = new Contactus();
        cs.setEmail(request.getParameter("email"));
        cs.setName(request.getParameter("name"));
        cs.setCountry(request.getParameter("Country"));
        cs.setMsg(request.getParameter("msg"));
        cs.setDate(Date.valueOf(request.getParameter("date")));

        logger.info("Update request for contact email: " + cs.getEmail());
        
        // Update contactus details
        ContactusServices serv = new ContactusServices();
        serv.Update(cs);

        RequestDispatcher dis = request.getRequestDispatcher("ReadData");
        dis.forward(request, response);
    }
}
