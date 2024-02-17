package AlertSystem.service.Alert;

import AlertSystem.service.EventInfo;

import java.util.List;

public class TumblingWindow extends AlertConfig{
    private int windowSizeInSecs;

    @Override
    boolean process(List<EventInfo> eventList) {
        return false;
    }
}
