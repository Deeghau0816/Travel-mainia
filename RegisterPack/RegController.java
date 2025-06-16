package RegisterPack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RegController {

    private static final Logger logger = LoggerUtil.getLogger(RegController.class);

    private static boolean isSuccess;
    private static Connection conct = null;
    private static Statement stm = null;
    private static ResultSet rSet = null;

    
    // Register a new user
    public static boolean insertdata(String name, String userName, String phone, String email, Date dob, String password) {
    	
        isSuccess = false;
        
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            String sql = "INSERT INTO register VALUES(0,'" + name + "','" + userName + "','" + phone + "','" + email + "','" + dob + "','" + password + "')";
            int rSet = stm.executeUpdate(sql);

            if (rSet > 0) {
                isSuccess = true;
                logger.info("User registered successfully: " + userName);
            } else {
                logger.warning("User registration failed: " + userName);
            }
        } catch (Exception e) {
            logger.severe("Registration error for user " + userName + ": " + e.toString());
        }
        return isSuccess;
    }

    
    //Validate login
    public static List<RegModel> loginValidate(String userName, String password) {
        ArrayList<RegModel> register = new ArrayList<>();
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            String sql = "SELECT * FROM register WHERE userName = '" + userName + "' AND password = '" + password + "'";
            rSet = stm.executeQuery(sql);

            if (rSet.next()) {
                RegModel userLogin = new RegModel(
                        rSet.getInt(1), rSet.getString(2), rSet.getString(3),
                        rSet.getString(4), rSet.getString(5), rSet.getDate(6), rSet.getString(7)
                );
                register.add(userLogin);
                logger.info("Login successful for user: " + userName);
            } else {
                logger.warning("Login failed: Invalid credentials for " + userName);
            }
        } catch (Exception e) {
            logger.severe("Login validation error for " + userName + ": " + e.toString());
        }
        return register;
    }
    
    
    //display user details in UserProfile
    public static List<RegModel> userProfile(String userId) {
    	
        int originalID = Integer.parseInt(userId);
        
        ArrayList<RegModel> register = new ArrayList<>();
        
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            
            String sql = "SELECT * FROM register WHERE userID = '" + originalID + "'";
            rSet = stm.executeQuery(sql);

            if (rSet.next()) {
                RegModel userLogin = new RegModel(
                        rSet.getInt(1), rSet.getString(2), rSet.getString(3),
                        rSet.getString(4), rSet.getString(5), rSet.getDate(6), rSet.getString(7)
                );
                
                
                register.add(userLogin);
                logger.info("Profile fetched for user ID: " + userId);
            }
        } catch (Exception e) {
            logger.severe("Error fetching profile for user ID " + userId + ": " + e.toString());
        }
        return register;
    }

    
    //Update user profile
    public static boolean updateProfile(String userId, String name, String userName, String phone, String email, Date dob, String password) {
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            
            String sql = "UPDATE register SET name='" + name + "',userName='" + userName + "',phone='" + phone + "',email='" + email + "',dob='" + dob + "',password='" + password + "' WHERE userId = '" + userId + "'";
            int rSet = stm.executeUpdate(sql);

            if (rSet > 0) {
                isSuccess = true;
                logger.info("User updated successfully: ID=" + userId);
            } else {
                isSuccess = false;
                logger.warning("Failed to update user ID: " + userId);
            }
        } catch (Exception e) {
            logger.severe("Update error for user ID " + userId + ": " + e.toString());
        }
        return isSuccess;
    }

    
    //used for update form display
    public static List<RegModel> getById(String userId) {
        int convertedId = Integer.parseInt(userId);
        ArrayList<RegModel> register = new ArrayList<>();
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            String sql = "SELECT * FROM register WHERE userID = '" + convertedId + "'";
            rSet = stm.executeQuery(sql);

            while (rSet.next()) {
                RegModel userdata = new RegModel(
                        rSet.getInt(1), rSet.getString(2), rSet.getString(3),
                        rSet.getString(4), rSet.getString(5), rSet.getDate(6), rSet.getString(7)
                );
                register.add(userdata);
            }

            logger.info("getById returned " + register.size() + " result(s) for ID: " + userId);
        } catch (Exception e) {
            logger.severe("Error fetching user by ID " + userId + ": " + e.toString());
        }
        return register;
    }

    
    //delete
    public static boolean userDelete(String userId) {
        int delId = Integer.parseInt(userId);
        try {
            conct = DvpRegConnect.getConnection();
            stm = conct.createStatement();
            String sql = "DELETE FROM register WHERE userId='" + delId + "'";
            int rSet = stm.executeUpdate(sql);

            if (rSet > 0) {
                isSuccess = true;
                logger.info("User deleted successfully: ID=" + userId);
            } else {
                isSuccess = false;
                logger.warning("Failed to delete user ID: " + userId);
            }
        } catch (Exception e) {
            logger.severe("Delete error for user ID " + userId + ": " + e.toString());
        }
        return isSuccess;
    }
}
