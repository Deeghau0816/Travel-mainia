package adminPackage;

import java.util.logging.Logger;

public class LoggerUtil {
	
	//Returns a logger specific to the admin class.
    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}
