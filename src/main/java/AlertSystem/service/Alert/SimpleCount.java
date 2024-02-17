package AlertSystem.service.Alert;

import AlertSystem.service.EventInfo;

import java.util.List;

public class SimpleCount extends AlertConfig {
    @Override
    boolean process(List<EventInfo> eventList) {
        return eventList.size() > threshold;
    }
}
