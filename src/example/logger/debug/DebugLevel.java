package example.logger.debug;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DebugLevel {

	private static final Log log = LogFactory.getLog(DebugLevel.class);

	public static void main(String[] args) {
		log.debug("Example debug message ..");
		log.info("Example info message ..");
		log.warn("Example warn message ..");
		log.error("Example error message ..");
		log.fatal("Example fatal message ..");

		try {
			raiseException();
		} catch (Exception e) {
			log.fatal("<Some Object>", e);
		}
	}

	private static void raiseException() throws Exception {
		throw new Exception("Test Exception");
	}
}
