package AlertSystem.service.Dispatcher;

import java.util.logging.Logger;

public class EmailDispatcher implements DispatchConfig{
    private String subject;
    private static final Logger logger = Logger.getLogger("AutoGeneration");

    public EmailDispatcher(String subject) {
        this.subject = subject;
    }

    @Override
    public void dispatch() {
        logger.info(subject);
    }
}
