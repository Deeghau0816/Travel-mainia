package servlets;

import java.io.IOException;
import java.io.IOException;
import model.Contactus;
import services.ContactusServices;
import services.LoggerUtil;
import java.sql.Date;
import java.util.logging.Logger;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contactus;
import services.ContactusServices;

import java.io.IOException;

@WebServlet("/ReadData")
public class ReadData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerUtil.getLogger(ReadData.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	 // Get email parameter 
    	String email = request.getParameter("email");
        logger.info("Reading data for contact email: " + email);

        // Prepare Contactus model with email
        Contactus cus = new Contactus();
        cus.setEmail(email);
        
        // Fetch message from service
        ContactusServices serv = new ContactusServices();
        Contactus msg = serv.getone(cus);

        // Set message as request attribute and forward to JSP
        request.setAttribute("msg1", msg);
        RequestDispatcher dis = request.getRequestDispatcher("readCont.jsp");
        dis.forward(request, response);
    }
}
