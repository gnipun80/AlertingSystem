package AlertSystem.service.serviceInit;

import java.util.HashMap;
import java.util.Map;
import AlertSystem.service.Event.*; // Import the EventConfig class

public class Client {
    private String name;

    private Map<String, EventConfig> eventConfigMap; // map <EventType, EventHandler>
    public Client() {
        this(null);
    }

    public Client(String name) {
        this.name = name;
        this.eventConfigMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, EventConfig> getEventConfigMap() {
        return eventConfigMap;
    }

    public void addEventConfig(EventConfig eventConfig) {
        eventConfigMap.put(eventConfig.getType(), eventConfig);
    }
}
