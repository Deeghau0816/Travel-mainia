package RegisterPack;

import java.sql.Date;
import java.util.logging.Logger;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DvpRegServlet")
public class DvpRegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
 // Logger to record the status
    private static final Logger logger = LoggerUtil.getLogger(DvpRegServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dobString = request.getParameter("dob");
        String password = request.getParameter("password");

        Date dob = Date.valueOf(dobString);
        logger.info("Registration attempt for: " + userName);

        //send data to controller and controller insert data in database
        boolean isTrue = RegController.insertdata(name, userName, phone, email, dob, password);

        if (isTrue) {
            logger.info("Registration successful for: " + userName);
            response.getWriter().println("<script>alert('Inserted successfully'); window.location.href='DvpLogin.jsp'</script>");
        } else {
            logger.warning("Registration failed for: " + userName);
            RequestDispatcher dsp2 = request.getRequestDispatcher("wrong.jsp");
            dsp2.forward(request, response);
        }
    }
}
