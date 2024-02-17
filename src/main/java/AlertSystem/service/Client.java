package AlertSystem.service;

import java.util.Map;

import AlertSystem.service.Event.EventConfig;

public class Client {
    private String name;

    private Map<String, EventConfig> EventConfigMap; // map <EventType, EventHandler>

    public Client(String name, Map<String, EventConfig> eventConfigMap) {
        this.name = name;
        EventConfigMap = eventConfigMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, EventConfig> getEventConfigMap() {
        return EventConfigMap;
    }

    public void setEventConfigMap(Map<String, EventConfig> eventConfigMap) {
        EventConfigMap = eventConfigMap;
    }
}
