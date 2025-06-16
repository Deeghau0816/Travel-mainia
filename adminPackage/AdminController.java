package adminPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import tourOfferPackage.DBConnection;

public class AdminController {

	// Logger for recording events, warnings, and errors
    private static final Logger logger = LoggerUtil.getLogger(AdminController.class);

    // Database-related variables
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    //Inserts new admin data 
    public static boolean insertdata(String name, String gmail, String password, String phone) {
        boolean isSuccess = false;
        try {
        	// Establish database connection
            con = DBConnection.getConnection();
            stmt = con.createStatement();

         // SQL query to insert admin data
            String sql = "insert into admin_log values(0,'" + name + "','" + gmail + "','" + password + "','" + phone + "')";
            int rs = stmt.executeUpdate(sql);

         // Check if insert was successful
            if (rs > 0) {
                isSuccess = true;
                logger.info("Admin registered successfully: " + gmail);
            } else {
                logger.warning("Admin registration failed: " + gmail);
            }
        } catch (Exception e) {
            logger.severe("Exception during admin registration: " + e.toString());
        }

        return isSuccess;
    }

    public static List<AdminModel> loginValidate(String gmail, String password) {
        ArrayList<AdminModel> admin = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String sql = "select * from admin_log where gmail='" + gmail + "' and password ='" + password + "'";
            rs = stmt.executeQuery(sql);


            // If login credentials match, create AdminModel object and add to list
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String passw1 = rs.getString(4);
                String phone = rs.getString(5);

                AdminModel a = new AdminModel(id, name, email, passw1, phone);
                admin.add(a);

                logger.info("Login validated for: " + gmail);
            } else {
                logger.warning("Login failed: Invalid credentials for " + gmail);
            }

        } catch (Exception e) {
        	
        	// Log any exceptions that occur
            logger.severe("Exception during login validation: " + e.toString());
        }
        return admin;
    }
}
