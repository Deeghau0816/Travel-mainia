package tourOfferPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class offerController {

    private static final Logger logger = LoggerUtil.getLogger(offerController.class);

 // Database connection objects
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    // Insert offer
    public static boolean insertdata(String title, String description, String price, String discount, String stdate, String edate) {
        boolean isSuccess = false;
        try {
        	// Get database connection
            con = DBConnection.getConnection();
            stmt = con.createStatement();

         // Create SQL insert statement
            String sql = "insert into offers values(0,'" + title + "','" + description + "','" + price + "','" + discount + "','" + stdate + "','" + edate + "')";
         // Execute update and check affected rows
            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
                logger.info("Inserted new offer: " + title);
            } else {
                logger.warning("Failed to insert offer: " + title);
            }
        } catch (Exception e) {
            logger.severe("Exception during offer insertion: " + e.toString());
        }
        return isSuccess;
    }

    
    // Get offer by ID
    public static List<offerModel> getById(String Id) {
        int convertedId = Integer.parseInt(Id);
        ArrayList<offerModel> offer = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            // SQL query to find offer by ID
            String sql = "select * from offers where id = '" + convertedId + "'";

            rs = stmt.executeQuery(sql);

            // Process result set
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                String price = rs.getString(4);
                String discount = rs.getString(5);
                String stdate = rs.getString(6);
                String edate = rs.getString(7);

             // Create offer model object and add to list
                offerModel bk = new offerModel(id, title, description, price, discount, stdate, edate);
                offer.add(bk);
            }

            logger.info("Fetched offer(s) by ID: " + Id);

        } catch (Exception e) {
            logger.severe("Exception during fetch by ID: " + e.toString());
        }
        return offer;
    }

    // Get all offers
    public static List<offerModel> getalloffer() {
        ArrayList<offerModel> offers = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
         // SQL query to get all offers
            String sql = "select * from offers";

            rs = stmt.executeQuery(sql);

            // Process all results
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                String price = rs.getString(4);
                String discount = rs.getString(5);
                String stdate = rs.getString(6);
                String edate = rs.getString(7);

                // Create offer model for each record
                offerModel bk = new offerModel(id, title, description, price, discount, stdate, edate);
                offers.add(bk);
            }

            logger.info("Fetched all offers.");

        } catch (Exception e) {
            logger.severe("Exception during fetch all offers: " + e.toString());
        }
        return offers;
    }

    // Update offer
    public static boolean updatedata(String id, String title, String description, String price, String discount, String stdate, String edate) {
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();

         // SQL update statement
            String sql = "update offers set title='" + title + "',description='" + description + "',price='" + price + "',discount='" + discount + "',stdate='" + stdate + "',edate='" + edate + "' where id='" + id + "'";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
                logger.info("Updated offer ID " + id + " successfully.");
            } else {
                isSuccess = false;
                logger.warning("Failed to update offer ID " + id);
            }

        } catch (Exception e) {
            logger.severe("Exception during offer update: " + e.toString());
        }
        return isSuccess;
    }

    
    // Delete offer
    public static boolean deletedata(String id) {
        int convID = Integer.parseInt(id);
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();

         // SQL delete statement
            String sql = "delete from offers where id='" + convID + "'";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
                logger.info("Deleted offer ID " + id + " successfully.");
            } else {
                isSuccess = false;
                logger.warning("Failed to delete offer ID " + id);
            }

        } catch (Exception e) {
            logger.severe("Exception during offer deletion: " + e.toString());
        }
        return isSuccess;
    }
}