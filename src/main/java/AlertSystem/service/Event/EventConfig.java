package AlertSystem.service.Event;

import AlertSystem.service.Alert.AlertConfig;
import AlertSystem.service.Dispatcher.DispatchConfig;

import java.util.ArrayList;
import java.util.List;

public class EventConfig {
    private String type;
    private List<EventInfo> events;
    private AlertConfig alertConfig;
    private List<DispatchConfig> dispatchConfigList;
    public EventConfig(String type, AlertConfig alertConfig, List<DispatchConfig> dispatchConfigList) {
        this.type = type;
        this.alertConfig = alertConfig;
        this.dispatchConfigList = dispatchConfigList;
        this.events = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public List<EventInfo> getEvents() {
        return events;
    }

    public AlertConfig getAlertConfig() {
        return alertConfig;
    }

    public List<DispatchConfig> getDispatchConfigList() {
        return dispatchConfigList;
    }

    public void addEvent(EventInfo event) {
        events.add(event);
        boolean isThresholdBreach = alertConfig.process(events);

        if(isThresholdBreach) {
            for(DispatchConfig d : dispatchConfigList) {
                d.dispatch();
            }
        }
    }
}
