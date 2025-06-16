package services;

import java.util.logging.Logger;

public class LoggerUtil {
	//class to get logger instances for ContactUs class
    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}
