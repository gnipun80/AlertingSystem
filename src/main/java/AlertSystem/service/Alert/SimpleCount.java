package AlertSystem.service.Alert;

import java.util.List;

import AlertSystem.Enums.ConfigType;
import AlertSystem.service.Event.EventInfo;

public class SimpleCount extends AlertConfig {
    public SimpleCount(ConfigType type, int count) {
        super(type, count);
    }
    @Override
    public boolean process(List<EventInfo> eventList) {
        return eventList.size() >= threshold;
    }
}
