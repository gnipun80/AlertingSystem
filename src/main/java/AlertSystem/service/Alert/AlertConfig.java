package AlertSystem.service.Alert;

import AlertSystem.service.EventInfo;

import java.util.List;

public abstract class AlertConfig {
    public int threshold;
    public String type;

    abstract boolean process(List<EventInfo> eventList);
}
