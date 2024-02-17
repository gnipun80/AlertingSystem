package AlertSystem.service.Alert;

import java.util.List;

import AlertSystem.service.Event.EventInfo;

public class SimpleCount extends AlertConfig {
    @Override
    boolean process(List<EventInfo> eventList) {
        return eventList.size() > threshold;
    }
}
