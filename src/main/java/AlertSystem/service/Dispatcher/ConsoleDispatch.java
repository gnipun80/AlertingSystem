package AlertSystem.service.Dispatcher;

import java.util.logging.Logger;

public class ConsoleDispatch implements DispatchConfig{
    private String displayMsg;
    private static final Logger logger = Logger.getLogger("Console Log");

    public ConsoleDispatch(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    @Override
    public void dispatch() {
        logger.info(displayMsg);
    }
}
