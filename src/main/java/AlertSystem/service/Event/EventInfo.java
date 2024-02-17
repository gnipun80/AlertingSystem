package AlertSystem.service.Event;

public class EventInfo {
    private int eventTime;
    public EventInfo(int ingestTimeStamp) {
        this.eventTime = ingestTimeStamp;
    }
    public int getEventTime() {
        return eventTime;
    }
}
