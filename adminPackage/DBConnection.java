package adminPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

//to handle Database connection
public class DBConnection {

	// Logger to record database connection events
    private static final Logger logger = LoggerUtil.getLogger(DBConnection.class);

    // Database connection URL, username, and password
    private static String url = "jdbc:mysql://localhost:3306/tour_offers";
    private static String user = "root";
    private static String pass = "@Deeghau0816";
    private static Connection con;

    // Establishes and returns a connection to the MySQL database.
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            logger.info("Database connection established successfully.");
        } catch (Exception e) {
            logger.severe("Database connection failed: " + e.toString());
        }
        return con;
    }
}
