package RegisterPack;

public class DvpConstants {

    // Database Configuration
    public static final String DB_URL = "jdbc:mysql://localhost:3306/tour_offers";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "@Deeghau0816";

    // Table Name
    public static final String TABLE_REGISTER = "register";

    // Column Names for 'register' table
    public static final String COL_USER_ID = "userId";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "userName";
    public static final String COL_EMAIL = "email";
    public static final String COL_PHONE = "phone";
    public static final String COL_PASSWORD = "password";
    public static final String COL_DOB = "dob";

    // Optional: You can add constants for validation or default values
    public static final String DATE_FORMAT = "yyyy-MM-dd"; // If you need to format DOB consistently

}