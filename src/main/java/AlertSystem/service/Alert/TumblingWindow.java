package AlertSystem.service.Alert;

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
        EventInfo lastEvent = eventList.get(eventList.size() - 1);
        int lastEventWindowIndex = (int) ((lastEvent.getEventTime() % (24 * 3600)) / windowSizeInSecs), count = 1;
        for (EventInfo event : eventList) {
            int currWindowIndex = (int) ((event.getEventTime() % (24 * 3600)) / windowSizeInSecs);
            if (event != lastEvent && currWindowIndex == lastEventWindowIndex) {
                count++;
            }
        }
        return count >= threshold;
    }
}
