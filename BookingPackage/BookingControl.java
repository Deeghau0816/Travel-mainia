package BookingPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookingControl {
//BookingControl handles CRUD operations on the 'booking' table in the database.
//Includes methods to insert, retrieve, update, and delete booking records.
	
    private static final Logger logger = LoggerUtil.getLogger(BookingControl.class);

    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    //INSERT DATA
    public static boolean insertdata(String name, String place, String date, String guide, String numofpeople) {
        isSuccess = false;
        try {
            //DB CONNECTION
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
            
            //SQL INSERT QUERY
            String sql = "insert into booking values(0,'" + name + "','" + place + "','" + date + "','" + guide + "','" + numofpeople + "')";
            int rs = stmt.executeUpdate(sql);
            if (rs > 0) {
                isSuccess = true;
                logger.info("Booking inserted successfully: " + name);
            } else {
                logger.warning("Failed to insert booking: " + name);
            }
        } catch (Exception e) {
            logger.severe("Insert error: " + e.toString());
        }
        return isSuccess;
    }

    //RETRIEVES DATA BY its ID
    public static List<BookingModel> getById(String Id) {
        int convertedID = Integer.parseInt(Id);
        ArrayList<BookingModel> booking = new ArrayList<>();
        try {
        	//DB CONNECTION
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
           
            //SQL READ QUERY
            String sql = "select * from booking where id = '" + convertedID + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                booking.add(new BookingModel(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                ));
            }
            logger.info("Fetched booking by ID: " + Id);
        } catch (Exception e) {
            logger.severe("getById error: " + e.toString());
        }
        return booking;
    }

    //READ DATA
    public static List<BookingModel> getAllBooking() {
        ArrayList<BookingModel> bookings = new ArrayList<>();
        try {
        	//DB CONNECTION
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
           
            //SQL READ ALL QUERY
            String sql = "select * from booking";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                bookings.add(new BookingModel(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                ));
            }
            logger.info("Fetched all bookings. Total: " + bookings.size());
        } catch (Exception e) {
            logger.severe("getAllBooking error: " + e.toString());
        }
        return bookings;
    }

    //UPDATE DATA
    public static boolean updatedata(String id, String name, String place, String date, String guide, String numofpeople) {
        try {
        	//DB CONNECTION
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
            
          //SQL UPDATE QUERY
            String sql = "update booking set name = '" + name + "',place='" + place + "',date='" + date + "',guide='" + guide + "',numofpeople='" + numofpeople + "' where id= '" + id + "'";
            int rs = stmt.executeUpdate(sql);
            if (rs > 0) {
                isSuccess = true;
                logger.info("Booking updated successfully: ID=" + id);
            } else {
                isSuccess = false;
                logger.warning("Failed to update booking ID: " + id);
            }
        } catch (Exception e) {
            logger.severe("Update error: " + e.toString());
        }
        return isSuccess;
    }

    //DELETE DATA
    public static boolean deletedata(String id) {
        int convID = Integer.parseInt(id);
        try {
        	//DB CONNECTION
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
            
          //SQL DELETE QUERY
            String sql = "delete from booking where id='" + convID + "'";
            int rs = stmt.executeUpdate(sql);
            if (rs > 0) {
                isSuccess = true;
                logger.info("Booking deleted successfully: ID=" + id);
            } else {
                isSuccess = false;
                logger.warning("Failed to delete booking ID: " + id);
            }
        } catch (Exception e) {
            logger.severe("Delete error: " + e.toString());
        }
        return isSuccess;
    }
}
