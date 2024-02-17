package AlertSystem.service.Alert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
        if(eventList.size() < threshold) {
            return false;
        }
        EventInfo lastEvent = eventList.get(eventList.size() - 1);
        Instant instant = Instant.ofEpochSecond(lastEvent.getEventTime());
        ZonedDateTime dateTime = instant.atZone(ZoneId.of("GMT"));
        ZonedDateTime startOfDay = dateTime.truncatedTo(ChronoUnit.DAYS);
        long diffInSeconds = ChronoUnit.SECONDS.between(startOfDay, dateTime);
        long lastEventWindow = diffInSeconds / windowSizeInSecs;
        int count = 0;
        for (int i = eventList.size() - threshold; i < eventList.size(); i++) {
            EventInfo event = eventList.get(i);
            instant = Instant.ofEpochSecond(event.getEventTime());
            dateTime = instant.atZone(ZoneId.of("GMT"));
            diffInSeconds = ChronoUnit.SECONDS.between(startOfDay, dateTime);
            long eventWindow = diffInSeconds / windowSizeInSecs;
            if (eventWindow == lastEventWindow) {
                count++;
            }
        }
        return count >= threshold;
    }
}
