package AlertSystem.service.Alert;

import java.time.LocalDateTime;
import java.util.List;

import AlertSystem.service.Event.EventInfo;

public class SlidingWindow extends AlertConfig{
    private int windowSizeInSecs;
    
    @Override
    boolean process(List<EventInfo> eventList) {
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
