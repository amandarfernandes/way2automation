package way2automation.w2atest.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static Logger logger = LogManager.getLogger(Base.class.getName());
	
	
	public static void info(String msg) {
		logger.info(msg);
		
	}

}
