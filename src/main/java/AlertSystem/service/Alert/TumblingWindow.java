package AlertSystem.service.Alert;

import AlertSystem.service.EventInfo;

import java.util.List;

public class TumblingWindow extends AlertConfig{
    private int windowSizeInSecs;

    @Override
    boolean process(List<EventInfo> eventList) {
        // Get current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate start time of the current window
        LocalDateTime windowStart = currentTime - (currentTime % windowSizeInSecs);

        if(eventCount > this.threshold) {
            int lastEventTime = eventList.get(eventCount - 1 - threshold).getEventTime();
            if(lastEventTime >= windowStart) { // threshold breach
                return true
            }
        }
        return false;
    }
}
