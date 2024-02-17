package AlertSystem.service.Alert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import AlertSystem.Enums.ConfigType;
import AlertSystem.service.Event.EventInfo;

public class TumblingWindow extends AlertConfig{
    private int windowSizeInSecs;
    public TumblingWindow(ConfigType type, int threshold, int windowSizeInSecs) {
        super(type, threshold);
        this.windowSizeInSecs = windowSizeInSecs;
    }

    @Override
    public boolean process(List<EventInfo> eventList) {
        // Get current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate start time of the current window
        long windowStart = currentTime.minusSeconds(currentTime.getSecond())
                                               .minusNanos(currentTime.getNano())
                                               .minusMinutes(currentTime.getMinute() % (windowSizeInSecs / 60))
                                               .toEpochSecond(ZoneOffset.UTC);
        int eventCount = eventList.size();

        if(eventCount > this.threshold) {
            int lastEventTime = eventList.get(eventCount - 1 - threshold).getEventTime();
            if(lastEventTime >= windowStart) { // threshold breach
                return true;
            }
        }
        return false;
    }
}
