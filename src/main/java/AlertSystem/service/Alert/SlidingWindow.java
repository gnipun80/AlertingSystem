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
        // Check if the current window has passed
        int currentTime = LocalDateTime.now().getHour();
        int eventCount = eventList.size();

        if(eventCount > this.threshold) {
            int lastEventTime = eventList.get(eventCount - 1 - threshold).getEventTime();
            if(currentTime - lastEventTime < this.windowSizeInSecs) {
                return true;
            }
        }
        
        return false;
    }
}
