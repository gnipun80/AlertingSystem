package AlertSystem.service.Alert;

import java.time.LocalDateTime;
import java.util.List;

import AlertSystem.Enums.ConfigType;
import AlertSystem.service.Event.EventInfo;

public class SlidingWindow extends AlertConfig{
    private int windowSizeInSecs;
    public SlidingWindow(ConfigType type, int threshold, int windowSizeInSecs) {
        super(type, threshold);
        this.windowSizeInSecs = windowSizeInSecs;
    }
    
    @Override
    public boolean process(List<EventInfo> eventList) {
        if (eventList.size() < threshold) {
            return false;
        }

        EventInfo lastEvent = eventList.get(eventList.size() - 1);
        EventInfo firstEvent = eventList.get(eventList.size() - threshold);
        return lastEvent.getEventTime() - firstEvent.getEventTime() <= windowSizeInSecs;
    }
}
