package AlertSystem.service.Alert;

import java.util.List;

import AlertSystem.Enums.ConfigType;
import AlertSystem.service.Event.EventInfo;

public abstract class AlertConfig {
    public int threshold;
    public ConfigType type;
    public AlertConfig(ConfigType type, int threshold) {
        this.type = type;
        this.threshold = threshold;
    }

    public abstract boolean process(List<EventInfo> eventList);
}
