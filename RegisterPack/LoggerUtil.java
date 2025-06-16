package RegisterPack;

import java.util.logging.Logger;

public class LoggerUtil {
	// Returns a logger for the Register class
    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}
