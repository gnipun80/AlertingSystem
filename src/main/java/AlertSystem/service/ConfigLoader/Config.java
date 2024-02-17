package AlertSystem.service.ConfigLoader;

import java.util.List;

public class Config {
    private String client;
    private String eventType;
    private AlertConfig alertConfig;
    private List<DispatchStrategy> dispatchStrategyList;
    public String getClient() {
        return client;
    }
    public String getEventType() {
        return eventType;
    }
    public AlertConfig getAlertConfig() {
        return alertConfig;
    }
    public List<DispatchStrategy> getDispatchStrategyList() {
        return dispatchStrategyList;
    }
}
