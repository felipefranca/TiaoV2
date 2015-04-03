package Util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtils {
	static Logger logger = Logger.getLogger(LogUtils.class);

	public static void log(Level level, Exception exception) {
		BasicConfigurator.configure();
		logger.setLevel(level);
		log(level, exception);
	}

}
