package services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import Controller.DBConnect;
import model.Contactus;

public class ContactusServices {

    private static final Logger logger = LoggerUtil.getLogger(ContactusServices.class);

 // Add a new contact message
    public void addMsg(Contactus cs) {
        try {
            String query = "INSERT INTO luhith VALUES('" + cs.getEmail() + "' , '" + cs.getName() + "' , '"
                    + cs.getCountry() + "', '" + cs.getDate() + "' , '" + cs.getMsg() + "' )";
            Statement stat = DBConnect.getConnection().createStatement();
            stat.executeUpdate(query);
            logger.info("Message added successfully for email: " + cs.getEmail());
        } catch (Exception e) {
            logger.severe("Error while adding message: " + e.getMessage());
            e.printStackTrace();
        }
    }

 // Retrieve a message by email
    public Contactus getone(Contactus us) {
        try {
            String query = "SELECT * FROM luhith WHERE email = '" + us.getEmail() + "'";
            Statement stat = DBConnect.getConnection().createStatement();
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                us.setName(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setCountry(rs.getString("Country"));
                us.setMsg(rs.getString("Msg"));
                us.setDate(rs.getDate("date"));
                logger.info("Message retrieved for email: " + us.getEmail());
                return us;
            } else {
                logger.warning("No message found for email: " + us.getEmail());
            }
        } catch (Exception e) {
            logger.severe("Error while retrieving message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    //Update existing contact message details
    public void Update(Contactus cs) {
        try {
            String query = "UPDATE luhith SET name = '" + cs.getName() + "' , Country = '" + cs.getCountry()
                    + "' , Date = '" + cs.getDate() + "' , Msg = '" + cs.getMsg() + "' WHERE email = '" + cs.getEmail() + "'";
            Statement stat = DBConnect.getConnection().createStatement();
            stat.executeUpdate(query);
            logger.info("Message updated for email: " + cs.getEmail());
        } catch (Exception e) {
            logger.severe("Error while updating message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Delete a message by email
    public void delet(Contactus cs) {
        try {
            String query = "DELETE from luhith WHERE email = '" + cs.getEmail() + "'";
            Statement stat = DBConnect.getConnection().createStatement();
            stat.executeUpdate(query);
            logger.info("Message deleted for email: " + cs.getEmail());
        } catch (Exception e) {
            logger.severe("Error while deleting message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
